package com.mongoDb.controller;

import com.mongoDb.entity.CustomUserDetail;
import com.mongoDb.entity.LoginRequestDTO;
import com.mongoDb.entity.LoginResponseDTO;
import com.mongoDb.entity.UserDTO;
import com.mongoDb.jwt.JwtTokenProvider;
import com.mongoDb.model.User;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.impl.UserImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final UserImpl userService;

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping(value = "/auth/sign-up")
    private ApiResponse<?> register(@RequestBody UserDTO registerRequest) {
        User user = new User();
        try {
            user = userService.createUser(registerRequest);
        } catch (Exception e) {
            return ApiResponse.failureWithCode(null, null, user);
        }
        return ApiResponse.successWithResult(user);
    }

    @PostMapping(value = "/auth/login")
    private ApiResponse<LoginResponseDTO> authenticateClient(@RequestBody LoginRequestDTO authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (Exception e) {
            return ApiResponse.failureWithCode("", "Error");
        }

        CustomUserDetail loadedUser = userService.loadUserByUsername(userName);

        String generatedToken = jwtTokenProvider.generateToken(loadedUser);

        return ApiResponse.successWithResult(new LoginResponseDTO(generatedToken));
    }

    @GetMapping(value = "/dashBoard")
    private String testToken() {
        return "Welcome to dashboard";
    }
}

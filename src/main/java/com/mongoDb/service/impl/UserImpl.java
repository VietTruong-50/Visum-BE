package com.mongoDb.service.impl;

import com.mongoDb.entity.CustomUserDetail;
import com.mongoDb.entity.UserDTO;
import com.mongoDb.model.User;
import com.mongoDb.repository.UserRepository;
import com.mongoDb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetail(user);
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(userDTO.getUserName());
        user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        user.setGender(userDTO.getGender());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setMobile(userDTO.getMobile());
        user.setBirthOfDate(userDTO.getBirthOfDate());
        try {
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }
}

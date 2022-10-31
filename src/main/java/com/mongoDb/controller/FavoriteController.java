package com.mongoDb.controller;

import com.mongoDb.request.FavoriteDTO;
import com.mongoDb.model.Song;
import com.mongoDb.model.User;
import com.mongoDb.repository.UserRepository;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.SongService;
import com.mongoDb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visum")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class FavoriteController {
    @Autowired
    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongService songService;


    @PostMapping(value = "", produces = "application/json")
    public ApiResponse<User> addFavoriteSong(@RequestBody FavoriteDTO favoriteDTO) {
        User user = userService.addFavoriteSong(favoriteDTO);
        return ApiResponse.successWithResult(user);
    }

    @DeleteMapping(value = "/user/{userId}/favorite/{songId}", produces = "application/json")
    public ApiResponse<User> deleteFavoriteSong(@PathVariable("userId") String userId, @PathVariable("songId") String songId) {
        User user = userService.removeFavoriteSong(userId, songId);
        return ApiResponse.successWithResult(user);
    }

    @GetMapping(value = "/favorites", produces = "application/json")
    public ApiResponse<Page<Song>> getFavoriteList(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUserName(username);
        Page<Song> favoriteList = userService.findFavoriteSongs(user.getId(), page - 1, size, sortBy);
        return ApiResponse.successWithResult(favoriteList);
    }
}

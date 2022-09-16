package com.mongoDb.controller;

import com.mongoDb.entity.FavoriteDTO;
import com.mongoDb.model.User;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/visum")
@AllArgsConstructor
public class FavoriteController {
    @Autowired
    private final UserService userService;

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
}

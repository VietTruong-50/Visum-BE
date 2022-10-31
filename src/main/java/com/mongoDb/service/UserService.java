package com.mongoDb.service;

import com.mongoDb.exception.CustomException;
import com.mongoDb.request.FavoriteDTO;
import com.mongoDb.request.PasswordDTO;
import com.mongoDb.request.UserDTO;
import com.mongoDb.model.Song;
import com.mongoDb.model.User;
import org.springframework.data.domain.Page;


public interface UserService {
    User createUser(UserDTO userDTO);
    User updateUser(String userId,UserDTO userDTO) throws CustomException;
    User addFavoriteSong(FavoriteDTO favoriteDTO);
    User removeFavoriteSong(String userId, String songId);
    User findByUserName(String userName);
    User changePassword(String userId, PasswordDTO passwordDTO) throws CustomException;
    Page<Song> findFavoriteSongs(String userId, int page, int size, String sortBy);
}

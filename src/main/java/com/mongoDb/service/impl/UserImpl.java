package com.mongoDb.service.impl;

import com.mongoDb.constants.ErrorCode;
import com.mongoDb.exception.CustomException;
import com.mongoDb.request.CustomUserDetail;
import com.mongoDb.request.FavoriteDTO;
import com.mongoDb.request.PasswordDTO;
import com.mongoDb.request.UserDTO;
import com.mongoDb.model.Song;
import com.mongoDb.model.User;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.repository.UserRepository;
import com.mongoDb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetail(user);
    }

    @Override
    public User createUser(UserDTO userDTO) {
        return userRepository.save(userDTO.toUser());
    }

    @Override
    public User updateUser(String userId, UserDTO userDTO) throws CustomException {
        Optional<User> user = userRepository.findById(userId);
        User updateUser;
        if (user.isPresent()) {
            updateUser = user.get();

            updateUser.setLastName(userDTO.getLastName() != null ? userDTO.getLastName() : updateUser.getLastName());
            updateUser.setFirstName(userDTO.getFirstName() != null ? userDTO.getFirstName() : updateUser.getFirstName());
            updateUser.setGender(userDTO.getGender() != null ? userDTO.getGender() : updateUser.getGender());
            updateUser.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : updateUser.getEmail());
            updateUser.setMobile(userDTO.getMobile() != null ? userDTO.getMobile() : updateUser.getMobile());
            updateUser.setBirthOfDate(userDTO.getBirthOfDate() != null ? userDTO.getBirthOfDate() : updateUser.getBirthOfDate());
            return userRepository.save(updateUser);
        }
        return null;
    }


    @Override
    public User addFavoriteSong(FavoriteDTO favoriteDTO) {
        Optional<User> user = userRepository.findById(favoriteDTO.getUserId());

        if (user.isPresent()) {
            User userToUpdate = user.get();
            Set<Song> favoriteSongs = userToUpdate.getFavoriteSongs();
            Song favoriteSong = songRepository.findSongById(favoriteDTO.getSongId()).orElse(null);
            favoriteSongs.add(favoriteSong);
            userToUpdate.setFavoriteSongs(favoriteSongs);

            return userRepository.save(userToUpdate);
        }
        return null;
    }

    @Override
    public User removeFavoriteSong(String userId, String songId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            User userToUpdate = user.get();
            Set<Song> favoriteSongs = userToUpdate.getFavoriteSongs();
            Song favoriteSong = songRepository.findSongById(songId).orElse(null);
            System.out.println(songId);
            favoriteSongs.remove(favoriteSong);
            userToUpdate.setFavoriteSongs(favoriteSongs);

            return userRepository.save(userToUpdate);
        }
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public User changePassword(String userId, PasswordDTO passwordDTO) throws CustomException{
        Optional<User> user = userRepository.findById(userId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (user.isPresent()) {
            User updateUser = user.get();
            if (encoder.matches(passwordDTO.getCurrentPassword(), updateUser.getPassword())) {
                updateUser.setPassword(new BCryptPasswordEncoder().encode(passwordDTO.getNewPassword()));
                return userRepository.save(updateUser);
            }else{
                throw new CustomException(ErrorCode.CURRENT_PASSWORD_NOT_EQUAL);
            }
        }
        return null;
    }

    public Page<Song> findFavoriteSongs(String userId, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Optional<User> user = userRepository.findById(userId);
        List<Song> favoriteList = new ArrayList<>();
        if (user.isPresent()) {
            favoriteList = user.get().getFavoriteSongs().stream().toList();
        }
        return new PageImpl<>(favoriteList, pageable, size);
    }
}

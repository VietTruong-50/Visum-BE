package com.mongoDb.service.impl;

import com.mongoDb.entity.CustomUserDetail;
import com.mongoDb.entity.FavoriteDTO;
import com.mongoDb.entity.UserDTO;
import com.mongoDb.model.Song;
import com.mongoDb.model.User;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.repository.UserRepository;
import com.mongoDb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findUserByUserName(username);
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
}

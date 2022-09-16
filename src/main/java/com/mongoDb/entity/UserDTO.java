package com.mongoDb.entity;

import com.mongoDb.enums.GenderEnum;
import com.mongoDb.model.Song;
import com.mongoDb.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userName;

    private String password;

    private GenderEnum gender;

    private String birthOfDate;

    private String firstName;

    private String lastName;

    private String mobile;

    private String email;

    private Set<Song> favoriteSongs;

    public User toUser(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setGender(gender);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setBirthOfDate(birthOfDate);
        user.setFavoriteSongs(favoriteSongs);
        return user;
    }
}

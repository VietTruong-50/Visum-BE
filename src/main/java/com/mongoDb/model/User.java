package com.mongoDb.model;

import com.mongoDb.enums.GenderEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "user")
public class User extends BaseModel{

    private String userName;

    private String password;

    private GenderEnum gender;

    private String birthOfDate;

    private String firstName;

    private String lastName;

    private String mobile;

//    private String role;

    private String email;

    @DBRef
    private Set<Song> favoriteSongs;
//    @DBRef(lazy = true)
//    private Set<Role> roles = new HashSet<>();
}

package com.mongoDb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongoDb.enums.GenderEnum;
import com.mongoDb.enums.StatusEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "user")
@JsonIgnoreProperties({"password"})
public class User extends BaseModel{

    @Indexed(unique = true)
    private String userName;

    private String password;

    private GenderEnum gender;

    private String birthOfDate;

    private String firstName;

    private String lastName;

    private String mobile;

    private StatusEnum status;

//    private String role;

    @Indexed(unique = true)
    private String email;

    @DBRef
    @JsonIgnore
    private Set<Song> favoriteSongs;
//    @DBRef(lazy = true)
//    private Set<Role> roles = new HashSet<>();
}

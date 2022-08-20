package com.mongoDb.model;

import com.mongoDb.enums.GenderEnum;
import com.mongoDb.enums.TypeEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String userName;

    private String password;

    private GenderEnum gender;

    private String birthOfDate;

    private String firstName;

    private String lastName;

    private String mobile;

//    private String role;

    private String email;

//    private Set<Role> roles = new HashSet<>();
}

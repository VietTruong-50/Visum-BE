package com.mongoDb.model;

import com.mongoDb.enums.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "user")
public class User {
    @Id
    private UUID uuid;
    private String userName;
    private String password;
    private Gender gender;
    private LocalDateTime birthOfDate;
    private String firstName;
    private String lastName;
    private String mobile;
    private String role;
    private String email;
}

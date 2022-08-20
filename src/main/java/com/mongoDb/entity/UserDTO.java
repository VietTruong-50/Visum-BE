package com.mongoDb.entity;

import com.mongoDb.enums.GenderEnum;
import com.mongoDb.enums.TypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String userName;

    private String password;

    private GenderEnum gender;

    private String birthOfDate;

    private String firstName;

    private String lastName;

    private String mobile;

    private String email;
}

package com.mongoDb.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}

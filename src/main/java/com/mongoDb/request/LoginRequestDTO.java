package com.mongoDb.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}

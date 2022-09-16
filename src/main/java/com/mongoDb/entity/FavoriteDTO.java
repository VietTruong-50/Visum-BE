package com.mongoDb.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FavoriteDTO {
    @NotNull
    private String songId;

    @NotNull
    private String userId;
}

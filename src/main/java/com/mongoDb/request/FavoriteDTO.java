package com.mongoDb.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FavoriteDTO {
    @NotNull
    private String userId;

    @NotNull
    private String songId;
}

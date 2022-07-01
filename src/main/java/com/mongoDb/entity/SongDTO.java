package com.mongoDb.entity;

import com.mongoDb.model.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private String title;
//    private Type type;
    private String image;
    private String thumbnail;
    private boolean vip;
//    private LocalDateTime createdAt;
}

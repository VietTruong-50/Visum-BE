package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document(collection = "song")
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    private UUID uuid;
    @Indexed(unique = true)
    private String title;
//    private Type type;
    private String image;
    private String thumbnail;
    private boolean vip;

}

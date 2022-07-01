package com.mongoDb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "artist")
public class Artist {
    @Id
    private UUID uuid;
    private String name;
    private String nickName;
    private List<Song> musicList;
    private List<Album> albumList;
}

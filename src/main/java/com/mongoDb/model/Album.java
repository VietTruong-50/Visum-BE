package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "album")
@AllArgsConstructor
public class Album {

    private String albumName;
    private String description;
    private List<Song> songList;
}

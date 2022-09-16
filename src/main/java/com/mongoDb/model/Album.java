package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "album")
@AllArgsConstructor
public class Album extends BaseModel{

    private String albumName;

    private String description;

    @DBRef
    private Set<Song> songList;

    public Album(){
        this.songList = new HashSet<>();
    }
}

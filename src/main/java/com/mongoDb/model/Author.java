package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Document(collection = "author")
@AllArgsConstructor
public class Author extends BaseModel{

    private String name;

    @DBRef
    private Set<Song> songs;

    public Author(){
        this.songs = new HashSet<>();
    }
}

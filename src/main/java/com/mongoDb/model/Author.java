package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "author")
@AllArgsConstructor
public class Author {
    @Id

    private String name;
    private List<Song> musicList;
}

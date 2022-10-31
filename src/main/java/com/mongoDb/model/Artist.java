package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "artist")
@AllArgsConstructor
@NoArgsConstructor
public class Artist extends BaseModel{

    private String artistName;

    private String description;

    @DBRef
    private Set<Song> songs;
}

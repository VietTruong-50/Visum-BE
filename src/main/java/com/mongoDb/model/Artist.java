package com.mongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "artist")
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    @Id
    private String artistId;

    private String artistName;

    private String description;

//    private List<Album> albumList;

}

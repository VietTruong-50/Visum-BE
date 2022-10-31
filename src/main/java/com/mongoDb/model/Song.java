package com.mongoDb.model;

import com.mongoDb.entities.SongAuthor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "song")
@AllArgsConstructor
@NoArgsConstructor
public class Song extends BaseModel{

    @Indexed(unique = true)
//    @TextIndexed(weight = 1)
    private String title;

    private String image;

//    @TextIndexed(weight = 2)
    private String thumbnail;

    private SongAuthor songAuthor;

    private Genre genre;

    private double duration;

    private boolean vip;
}

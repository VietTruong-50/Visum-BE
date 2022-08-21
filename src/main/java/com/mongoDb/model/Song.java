package com.mongoDb.model;

import com.mongoDb.entity.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Data
@Document(collection = "song")
@AllArgsConstructor
@NoArgsConstructor
public class Song extends BaseModel{

    @Indexed(unique = true)
    private String title;

    private Type type;

    private String image;

    private String thumbnail;

    private boolean vip;
}

package com.mongoDb.entities;

import com.mongoDb.enums.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class Music {
    @Id
    private UUID id;
    @Indexed(unique = true)
    private String title;
    private String type;
    private String image;
    private String thumbnail;
    private List<Author> authorList;
    private List<Artist> artistList;
    private Album album;
    private boolean vip;
    private LocalDateTime createdAt;
}

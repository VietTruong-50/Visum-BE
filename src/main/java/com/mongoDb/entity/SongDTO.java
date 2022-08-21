package com.mongoDb.entity;

import com.mongoDb.model.Song;
import com.mongoDb.model.Type;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class SongDTO {
    @NotBlank(message = "Title not blank")
    private String title;

    private Type type;

    @NotBlank
    private String image;

    @NotBlank
    private String thumbnail;

    @NotNull
    private boolean vip;

    public Song toSong(){
        String songId = UUID.randomUUID().toString();
        Song song = new Song();
        song.setId(songId);
        song.setTitle(title);
        song.setImage(image);
        song.setThumbnail(thumbnail);
        song.setType(type);
        song.setVip(vip);
        return song;
    }

//    @NotEmpty
//    private List<Artist> artistList;
}

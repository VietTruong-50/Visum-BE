package com.mongoDb.entity;

import com.mongoDb.enums.GenreEnum;
import com.mongoDb.model.Song;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class SongDTO {
    @NotBlank(message = "Title not blank")
    private String title;

    @NotBlank
    private String image;

    @NotBlank
    private String thumbnail;

    private GenreEnum genre;

    @NotNull
    private boolean vip;

    public Song toSong(){
        Song song = new Song();
        String songId = UUID.randomUUID().toString();
        song.setId(songId);
        song.setTitle(title);
        song.setImage(image);
        song.setThumbnail(thumbnail);
        song.setGenre(genre);
        song.setVip(vip);
        return song;
    }

    public Song toUpdateSong(Song song){
        song.setTitle(title);
        song.setImage(image);
        song.setThumbnail(thumbnail);
        song.setGenre(genre);
        song.setVip(vip);
        return song;
    }

//    @NotEmpty
//    private List<Artist> artistList;
}

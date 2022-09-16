package com.mongoDb.entity;

import com.mongoDb.model.Album;
import com.mongoDb.model.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
    private String albumName;

    private String description;

    private Set<Song> songList;

    public Album toAlbum(){
        String id = UUID.randomUUID().toString();
        Album album = new Album();
        album.setId(id);
        album.setAlbumName(albumName);
        album.setDescription(description);
        album.setSongList(songList);
        return album;
    }
}

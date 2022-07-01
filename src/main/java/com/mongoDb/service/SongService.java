package com.mongoDb.service;

import com.mongoDb.entity.SongDTO;
import com.mongoDb.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<Song> getAllSong();
    Song createSong(SongDTO songDTO);
    Optional<Song> getSongByUUID(String uuid);
    void deleteSong(String uuid);
}

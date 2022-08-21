package com.mongoDb.service;

import com.mongoDb.entity.SongDTO;
import com.mongoDb.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<Song> findAll();
    Song createSong(SongDTO songDTO);
    List<Song> createListSong(List<SongDTO> songDTOS);
    Song updateSong(SongDTO songDTO, String id);
    Optional<Song> getSongById(String uuid);
    void deleteSong(String uuid);
    List<Song> findSongsByTitle(String title);
}

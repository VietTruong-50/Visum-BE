package com.mongoDb.service;

import com.mongoDb.request.SongDTO;
import com.mongoDb.model.Song;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<Song> findAll();
    Song createSong(SongDTO songDTO);
    List<Song> createListSong(List<SongDTO> songDTOS);
    Song updateSong(SongDTO songDTO, String id);
    Optional<Song> getSongById(String uuid);
    void deleteSong(String uuid);
    Page<Song> findSongsByTitle(String title, int page, int size, String sortBy);
    Page<Song> findSongsByCategory(List<String> category, int page, int size, String sortBy);

}

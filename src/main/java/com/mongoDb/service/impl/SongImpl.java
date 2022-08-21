package com.mongoDb.service.impl;

import com.mongoDb.entity.SongDTO;
import com.mongoDb.model.Song;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song createSong(SongDTO songDTO) {
        return songRepository.save(songDTO.toSong());
    }

    @Override
    public List<Song> createListSong(List<SongDTO> songDTOS) {
        List<Song> songs = songDTOS
                .stream()
                .map(SongDTO::toSong).toList();

        return songRepository.saveAll(songs);
    }

    @Override
    public Song updateSong(SongDTO songDTO, String id) {
        Song updateSong;
        Optional<Song> song = getSongById(id);
        if (song.isPresent()) {
            updateSong = song.get();
            updateSong.setTitle(songDTO.getTitle());
            updateSong.setImage(songDTO.getImage());
            updateSong.setThumbnail(songDTO.getThumbnail());
            updateSong.setVip(songDTO.isVip());
            return songRepository.save(updateSong);
        }
        return null;
    }

    @Override
    public Optional<Song> getSongById(String id) {
        return songRepository.findSongById(id);
    }

    @Override
    public void deleteSong(String id) {
        songRepository.deleteById(id);
    }

    @Override
    public List<Song> findSongsByTitle(String title) {
        return songRepository.findSongsByTitleContaining(title);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}

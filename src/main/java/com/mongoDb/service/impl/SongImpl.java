package com.mongoDb.service.impl;

import com.mongoDb.entity.SongDTO;
import com.mongoDb.model.Song;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SongImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song createSong(SongDTO songDTO) {
        UUID uuid = UUID.randomUUID();
        Song song = new Song(uuid,
                songDTO.getTitle(),
//                songDTO.getType(),
                songDTO.getImage(),
                songDTO.getThumbnail(),
                songDTO.isVip());
        return songRepository.save(song);
    }

    @Override
    public Optional<Song> getSongByUUID(String uuid) {
        return songRepository.findSongByUuid(UUID.fromString(uuid));
    }

    @Override
    public void deleteSong(String uuid) {
        songRepository.deleteById(uuid);
    }

    @Override
    public List<Song> getAllSong() {
        return songRepository.findAll();
    }


}

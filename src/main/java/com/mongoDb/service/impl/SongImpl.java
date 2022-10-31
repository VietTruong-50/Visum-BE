package com.mongoDb.service.impl;

import com.mongoDb.request.SongDTO;
import com.mongoDb.model.Song;
import com.mongoDb.repository.ArtistRepository;
import com.mongoDb.repository.GenreRepository;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Song createSong(SongDTO songDTO) {
//        songDTO.setArtist(artistRepository.findById(songDTO.getArtist().getId()).orElse(null));
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
//        Song updateSong;
        Optional<Song> song = getSongById(id);
        song.ifPresent(value -> songRepository.save(songDTO.toUpdateSong(value)));
//        if (song.isPresent()) {
//            updateSong = song.get();
//            return songRepository.save(songDTO.toUpdateSong(updateSong));
//        }
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
    public Page<Song> findSongsByTitle(String title, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return songRepository.findSongsByTitleContaining(title, pageable);
    }

    @Override
    public Page<Song> findSongsByCategory(List<String> category, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return songRepository.findSongsByGenreCategoryContaining(category,  pageable);
    }


    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    public List<Song> findSongBySearchText(String text){
//        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);
//
//        Query query = TextQuery.queryText(textCriteria).sortByScore();
//
//        return mongoTemplate.find(query, Song.class);
//    }
}

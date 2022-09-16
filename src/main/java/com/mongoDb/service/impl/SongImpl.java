package com.mongoDb.service.impl;

import com.mongoDb.entity.SongDTO;
import com.mongoDb.enums.GenreEnum;
import com.mongoDb.model.Song;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            return songRepository.save(songDTO.toUpdateSong(updateSong));
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
    public Page<Song> findSongsByGenre(GenreEnum genre, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return songRepository.findSongsByGenre(genre, pageable);
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

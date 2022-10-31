package com.mongoDb.repository;

import com.mongoDb.enums.GenreEnum;
import com.mongoDb.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends MongoRepository<Song, String>{
    Optional<Song> findSongById(String uuid);
    Page<Song> findSongsByTitleContaining(String title, Pageable pageable);
    Page<Song> findSongsByGenreCategoryContaining(List<String> genre_category, Pageable pageable);
}

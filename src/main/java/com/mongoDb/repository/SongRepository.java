package com.mongoDb.repository;

import com.mongoDb.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends MongoRepository<Song, String>{
    Optional<Song> findSongById(String uuid);
    List<Song> findSongsByTitleContaining(String title);
}

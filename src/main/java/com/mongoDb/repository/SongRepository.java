package com.mongoDb.repository;

import com.mongoDb.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SongRepository extends MongoRepository<Song, String>{
    Optional<Song> findSongByUuid(UUID uuid);
}

package com.mongoDb.repository;

import com.mongoDb.entities.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Music, String> {
    Optional<Music> findStudentByEmail(String email);
}

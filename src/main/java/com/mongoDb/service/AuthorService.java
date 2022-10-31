package com.mongoDb.service;

import com.mongoDb.request.AuthorDTO;
import com.mongoDb.model.Author;

import java.util.List;


public interface AuthorService {
    List<Author> findAll();
    Author createAuthor(AuthorDTO authorDTO);
    Author updateAuthor(AuthorDTO authorDTO, String id);
    Author addSongToAuthor(String id, List<String> songsId);
    Author findById(String id);
}

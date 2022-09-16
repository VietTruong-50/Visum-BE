package com.mongoDb.service.impl;

import com.mongoDb.entity.AuthorDTO;
import com.mongoDb.model.Author;
import com.mongoDb.model.Song;
import com.mongoDb.repository.AuthorRepository;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(AuthorDTO authorDTO) {
        return authorRepository.save(authorDTO.toAuthor());
    }

    @Override
    public Author updateAuthor(AuthorDTO authorDTO, String id) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()) {
            Author updateAuthor = author.get();
            updateAuthor.setName(authorDTO.getName());
            return authorRepository.save(updateAuthor);
        }

        return null;
    }

    @Override
    public Author addSongToAuthor(String id, List<String> songsId) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()){
            Author authorToUpdate = author.get();

            Set<Song> songsToAdd = songsId
                    .stream()
                    .map(songId -> songRepository.findSongById(songId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());

            authorToUpdate.setSongs(songsToAdd);

            return authorRepository.save(authorToUpdate);
        }
        return null;
    }

}

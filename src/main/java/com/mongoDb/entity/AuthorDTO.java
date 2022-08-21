package com.mongoDb.entity;

import com.mongoDb.model.Author;
import com.mongoDb.model.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private String name;

    private Set<Song> songList;

    public Author toAuthor(){
        Author author = new Author();
        String authorId = UUID.randomUUID().toString();
        author.setId(authorId);
        author.setName(name);
        author.setSongs(songList);
        return author;
    }
}

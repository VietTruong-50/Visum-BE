package com.mongoDb.controller;

import com.mongoDb.entity.AuthorDTO;
import com.mongoDb.entity.SongDTO;
import com.mongoDb.model.Author;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.impl.AuthorImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/visum")
@AllArgsConstructor
public class AuthorController {

    @Autowired
    private AuthorImpl authorImpl;

    @PutMapping(value = "/authors/{authorId}", produces = "application/json")
    public ApiResponse<Author> updateAuthor(@PathVariable("authorId") String id, @RequestBody AuthorDTO authorDTO){
        Author author = authorImpl.updateAuthor(authorDTO, id);
        return ApiResponse.successWithResult(author);
    }

    @PostMapping(value = "/authors/{id}/songs", produces = "application/json")
    public ApiResponse<Author> addSongToAuthor(@PathVariable("id") String id, @RequestBody List<String> songsId){
        Author author = authorImpl.addSongToAuthor(id, songsId);
        return ApiResponse.successWithResult(author);
    }

}

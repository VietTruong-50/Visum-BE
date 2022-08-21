package com.mongoDb.controller;

import com.mongoDb.entity.AuthorDTO;
import com.mongoDb.entity.SongDTO;
import com.mongoDb.exception.NotFoundException;
import com.mongoDb.model.Author;
import com.mongoDb.model.Song;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.AuthorService;
import com.mongoDb.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/visum")
@AllArgsConstructor
public class SongController {

    @Autowired
    private final SongService songService;

    @PostMapping(value = "/insertSong", produces = "application/json")
    public ApiResponse<Song> createSong(@RequestBody @Valid SongDTO songDTO)  {
        Song song = songService.createSong(songDTO);
        return ApiResponse.successWithResult(song);
    }

    @PostMapping(value = "/insertListSong", produces = "application/json")
    public ApiResponse<List<Song>> createSong(@RequestBody @Valid List<SongDTO> songDTO)  {
        List<Song> songs = songService.createListSong(songDTO);
        return ApiResponse.successWithResult(songs);
    }

    @GetMapping(value = "/songs", produces = "application/json")
    public ApiResponse<List<Song>> getSong() {
        List<Song> songList = songService.findAll();
        return ApiResponse.successWithResult(songList);
    }

//    @GetMapping(value = "/songs/?id={songId}", produces = "application/json")
//    public ApiResponse<Optional<Song>> findSongByUUID(@PathVariable("songId") String songId) throws NotFoundException {
//        Optional<Song> song = songService.getSongByUUID(songId);
//        return ApiResponse.successWithResult(song);
//    }

    @GetMapping(value = "/songs/?title={songTitle}", produces = "application/json")
    public ApiResponse<List<Song>> findSongsByTitle(@PathVariable("songTitle") String songTitle) throws NotFoundException {
        List<Song> songList = songService.findSongsByTitle(songTitle);
        return ApiResponse.successWithResult(songList);
    }

    @PutMapping(value = "/songs/{songId}", produces = "application/json")
    public ApiResponse<Song> updateSong(@PathVariable("songId") String id, @RequestBody SongDTO songDTO) {
        Song song = songService.updateSong(songDTO, id);
        return ApiResponse.successWithResult(song);
    }

    @DeleteMapping(value = "/songs/{songId}", produces = "application/json")
    public ApiResponse<Song> deleteSong(@PathVariable("songId") String id) {
        songService.deleteSong(id);
        return ApiResponse.successWithResult(null, "");
    }

    @Autowired
    private final AuthorService authorService;

    @PostMapping(value = "/insertAuthor", produces = "application/json")
    public ApiResponse<Author> createAuthor(@RequestBody AuthorDTO authorDTO){
        Author author = authorService.createAuthor(authorDTO);
        return ApiResponse.successWithResult(author);
    }
}

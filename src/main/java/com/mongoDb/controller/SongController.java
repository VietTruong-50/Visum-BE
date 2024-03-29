package com.mongoDb.controller;

import com.mongoDb.entity.SongDTO;
import com.mongoDb.enums.GenreEnum;
import com.mongoDb.exception.NotFoundException;
import com.mongoDb.model.Song;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.impl.SongImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/visum")
@AllArgsConstructor
public class SongController {

    @Autowired
    private final SongImpl songImpl;

    @PostMapping(value = "/insertSong", produces = "application/json")
    public ApiResponse<Song> createSong(@RequestBody @Valid SongDTO songDTO) {
        Song song = songImpl.createSong(songDTO);
        return ApiResponse.successWithResult(song);
    }

    @PostMapping(value = "/insertListSong", produces = "application/json")
    public ApiResponse<List<Song>> createSong(@RequestBody @Valid List<SongDTO> songDTO) {
        List<Song> songs = songImpl.createListSong(songDTO);
        return ApiResponse.successWithResult(songs);
    }

    @GetMapping(value = "/songs", produces = "application/json")
    public ApiResponse<List<Song>> getSong() {
        List<Song> songList = songImpl.findAll();
        return ApiResponse.successWithResult(songList);
    }

//    @GetMapping(value = "/songs/?id={songId}", produces = "application/json")
//    public ApiResponse<Optional<Song>> findSongByUUID(@PathVariable("songId") String songId) throws NotFoundException {
//        Optional<Song> song = songImpl.getSongByUUID(songId);
//        return ApiResponse.successWithResult(song);
//    }

    @GetMapping(value = "/search", produces = "application/json")
    public ApiResponse<List<Song>> findSongsByTitle(@RequestParam String title) throws NotFoundException {
        List<Song> songList = songImpl.findSongsByTitle(title);
        return ApiResponse.successWithResult(songList);
    }

    @GetMapping(value = "/songs/{genre}", produces = "application/json")
    public ApiResponse<Page<Song>> findSongsByGenre(@PathVariable("genre") GenreEnum genre,
                                                    @RequestParam int page,
                                                    @RequestParam int size,
                                                    @RequestParam String sortBy) throws NotFoundException {
        Page<Song> songList = songImpl.findSongsByGenre(genre, page - 1, size, sortBy);
        return ApiResponse.successWithResult(songList);
    }

    @PutMapping(value = "/songs/{songId}", produces = "application/json")
    public ApiResponse<Song> updateSong(@PathVariable("songId") String id, @RequestBody SongDTO songDTO) {
        Song song = songImpl.updateSong(songDTO, id);
        return ApiResponse.successWithResult(song);
    }

    @DeleteMapping(value = "/songs/{songId}", produces = "application/json")
    public ApiResponse<Song> deleteSong(@PathVariable("songId") String id) {
        songImpl.deleteSong(id);
        return ApiResponse.successWithResult(null, "");
    }


}

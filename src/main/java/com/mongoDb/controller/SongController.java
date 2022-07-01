package com.mongoDb.controller;

import com.mongoDb.entity.SongDTO;
import com.mongoDb.model.Song;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/visum")
@AllArgsConstructor
public class SongController {

    @Autowired
    private final SongService songService;

    @PostMapping(value = "/insertSong", produces = "application/json")
    public ApiResponse<Song> createSong(@RequestBody SongDTO songDTO){
        Song song = songService.createSong(songDTO);
        return ApiResponse.successWithResult(song);
    }

    @GetMapping(value = "/songs", produces = "application/json")
    public ApiResponse<List<Song>> getSong(){
        List<Song> songList = songService.getAllSong();
        return ApiResponse.successWithResult(songList);
    }

    @GetMapping(value = "/songs/{songId}", produces = "application/json")
    public ApiResponse<Optional<Song>> findSongByUUID(@PathVariable("songId") String songId){
        Optional<Song> song = songService.getSongByUUID(songId);
        return ApiResponse.successWithResult(song);
    }

    @DeleteMapping(value = "/songs/{songId}", produces = "application/json")
    public ApiResponse<Song> deleteSong(@PathVariable("songId") String songId){
        songService.deleteSong(songId);
        return ApiResponse.successWithResult(null, "");
    }
}

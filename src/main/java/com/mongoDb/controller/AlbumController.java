package com.mongoDb.controller;

import com.mongoDb.entity.AlbumDTO;
import com.mongoDb.model.Album;
import com.mongoDb.response.ApiResponse;
import com.mongoDb.service.impl.AlbumImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/visum")
@AllArgsConstructor
public class AlbumController {

    @Autowired
    private AlbumImpl albumImpl;

    @PostMapping(value = "/insertAlbum", produces = "application/json")
    public ApiResponse<Album> createAlbum(@RequestBody AlbumDTO albumDTO){
        Album album = albumImpl.createAlbum(albumDTO);
        return ApiResponse.successWithResult(album);
    }

    @PostMapping(value = "/albums/{id}/songs", produces = "application/json")
    public ApiResponse<Album> addSongToAuthor(@PathVariable("id") String id, @RequestBody List<String> songsId) {
        Album album = albumImpl.addSongsToAlbum(id, songsId);
        return ApiResponse.successWithResult(album);
    }
}

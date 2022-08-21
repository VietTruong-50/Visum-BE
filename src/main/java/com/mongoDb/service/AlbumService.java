package com.mongoDb.service;

import com.mongoDb.entity.AlbumDTO;
import com.mongoDb.model.Album;

import java.util.List;

public interface AlbumService {
    Album createAlbum(AlbumDTO albumDTO);
    Album addSongsToAlbum(String id, List<String> songsId);
}

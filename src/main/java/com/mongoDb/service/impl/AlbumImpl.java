package com.mongoDb.service.impl;

import com.mongoDb.request.AlbumDTO;
import com.mongoDb.model.Album;
import com.mongoDb.model.Song;
import com.mongoDb.repository.AlbumRepository;
import com.mongoDb.repository.SongRepository;
import com.mongoDb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlbumImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Override
    public Album createAlbum(AlbumDTO albumDTO) {
        return albumRepository.save(albumDTO.toAlbum());
    }

    @Override
    public Album addSongsToAlbum(String id, List<String> songsId) {
        Optional<Album> album = albumRepository.findById(id);

        if(album.isPresent()){
            Album albumToUpdate = album.get();

            Set<Song> songs = songsId
                    .stream()
                    .map(songId -> songRepository.findSongById(songId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());

            albumToUpdate.setSongList(songs);
            return albumRepository.save(albumToUpdate);
        }
        return null;
    }
}

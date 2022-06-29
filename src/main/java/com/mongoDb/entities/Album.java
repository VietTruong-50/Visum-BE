package com.mongoDb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Album {
    private List<Music> musicList;
}

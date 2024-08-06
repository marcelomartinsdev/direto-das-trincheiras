package com.marcelomartinsdev.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Anime {
    public String name;
    private Long id;

    public static List<Anime> animeList() {
        var onePiece = new Anime("One Piece", 1L);
        var moshukoTensei = new Anime("Moshuko Tensei", 2L);
        var naruto = new Anime("Naruto", 3L);

        return List.of(onePiece, moshukoTensei, naruto);
    }
}


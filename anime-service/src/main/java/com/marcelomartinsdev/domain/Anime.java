package com.marcelomartinsdev.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Anime {
    private Long id;
    public String name;

    public Anime(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Anime> animeList() {
        var onePiece = new Anime(1L, "One Piece");
        var moshukoTensei = new Anime(2L, "Moshuko Tensei");
        var naruto = new Anime(3L, "Naruto");

        return List.of(onePiece, moshukoTensei, naruto);
    }

}


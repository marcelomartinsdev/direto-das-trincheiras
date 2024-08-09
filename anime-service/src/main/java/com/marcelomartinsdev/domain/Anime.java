package com.marcelomartinsdev.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Anime {
    private static List<Anime> animes = new ArrayList<Anime>();

    static {
        var onePiece = new Anime("One Piece", 1L);
        var naruto = new Anime("Naruto", 2L);
        var dragonBallZ = new Anime("Dragon Ball Z", 3L);

        animes.addAll(List.of(onePiece, naruto, dragonBallZ));
    }

    public String name;
    private Long id;

    public static List<Anime> getAnimes() {
        return animes;
    }
}


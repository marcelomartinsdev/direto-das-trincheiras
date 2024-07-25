package com.marcelomartinsdev.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/v1/animes")
@Slf4j
public class AnimeController {

    @GetMapping
    public List<String> animeList() throws InterruptedException {
        log.info(Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(1);
        return List.of(
                "Fullmetal Alchemist: Brotherhood - Nota: 9.1",
                "Attack on Titan - Nota: 9.1",
                "Steins;Gate - Nota: 8.8",
                "Hunter x Hunter - Nota: 9.0",
                "Death Note - Nota: 8.9",
                "One Punch Man - Nota: 8.7",
                "Naruto: Shippuden - Nota: 8.7",
                "Cowboy Bebop - Nota: 8.9",
                "Code Geass - Nota: 8.7",
                "Dragon Ball Z - Nota: 8.8",
                "One Piece - Nota: 9.0",
                "Vinland Saga - Nota: 8.8",
                "My Hero Academia - Nota: 8.5",
                "Neon Genesis Evangelion - Nota: 8.5",
                "Ghost in the Shell: Stand Alone Complex - Nota: 8.5",
                "Demon Slayer: Kimetsu no Yaiba - Nota: 8.6",
                "Berserk - Nota: 8.7",
                "Trigun - Nota: 8.2",
                "FLCL - Nota: 8.1",
                "Dragon Ball - Nota: 8.5"
        );
    }
}

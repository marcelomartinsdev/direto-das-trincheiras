package com.marcelomartinsdev.controllers;

import com.marcelomartinsdev.domain.Anime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/v1/animes")
@Slf4j
public class AnimeController {


    @GetMapping
    public List<Anime> listAll() {
        return Anime.getAnimes();
    }

    @GetMapping("filter")
    public List<Anime> filter(@RequestParam(required = false) String name) {
        var animes = Anime.getAnimes();
        if (name == null || name.isEmpty()) {
            return animes;
        }
        return animes.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public Anime findById(@PathVariable Long id) {
        return Anime.getAnimes().stream().filter(anime -> anime.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Anime save(@RequestBody Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(100_000));
        Anime.getAnimes().add(anime);
        return anime;
    }
}

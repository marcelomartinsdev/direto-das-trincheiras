package com.marcelomartinsdev.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/heroes")
public class HeroController {
    private static final List<String> HEROES = List.of("Goku (Dragon Ball Z)",
            "Goku (Dragon Ball Z)",
            "Naruto Uzumaki (Naruto)",
            "Monkey D. Luffy (One Piece)",
            "Ichigo Kurosaki (Bleach)",
            "Saitama (One Punch Man)",
            "Eren Jaeger (Attack on Titan)",
            "Edward Elric (Fullmetal Alchemist: Brotherhood)",
            "Light Yagami (Death Note)",
            "Tanjiro Kamado (Demon Slayer: Kimetsu no Yaiba)",
            "Guts (Berserk)");

    @GetMapping
    public List<String> listAllHeroes() {
        return HEROES;
    }

    @GetMapping("filter")
    public List<String> filter(@RequestParam String name) {
        return HEROES.stream().filter(hero -> hero.equalsIgnoreCase(name)).toList();
    }

    @GetMapping("filterList")
    public List<String> filterList(@RequestParam List<String> names) {
        return HEROES.stream().filter(names::contains).toList();
    }

    @GetMapping("{name}")
    public String findByName(@PathVariable String name) {
        return HEROES
                .stream()
                .filter(hero -> hero.equalsIgnoreCase(name))
                .findFirst().orElse("Not find Hero");
    }
}

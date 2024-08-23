package com.marcelomartinsdev.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Producer {
    private static List<Producer> producers = new ArrayList<>();

    static {
        var marcelo = Producer.builder().name("Marcelo").id(1L).createdAt(LocalDateTime.now()).build();
        var joao = Producer.builder().name("Joao").id(2L).createdAt(LocalDateTime.now()).build();
        var roberto = Producer.builder().name("Roberto").id(3L).createdAt(LocalDateTime.now()).build();

        producers.addAll(List.of(marcelo, joao, roberto));
    }

    @JsonProperty("name")
    public String name;
    private Long id;
    private LocalDateTime createdAt;

    public static List<Producer> getProducers() {
        return producers;
    }
}



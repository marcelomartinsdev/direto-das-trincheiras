package com.marcelomartinsdev.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Producer {
    private static List<Producer> producers = new ArrayList<Producer>();

    static {
        var marcelo = new Producer("Marcelo", 1L);
        var joao = new Producer("Joao", 2L);
        var roberto = new Producer("Roberto", 3L);

        producers.addAll(List.of(marcelo, joao, roberto));
    }

    @JsonProperty("name")
    public String name;
    private Long id;

    public static List<Producer> getProducers() {
        return producers;
    }
}



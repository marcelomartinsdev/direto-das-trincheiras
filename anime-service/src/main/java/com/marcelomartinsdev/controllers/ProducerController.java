package com.marcelomartinsdev.controllers;

import com.marcelomartinsdev.domain.Producer;
import com.marcelomartinsdev.request.ProducerPostRequest;
import com.marcelomartinsdev.response.ProducerGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/v1/producers")
@Slf4j
public class ProducerController {


    @GetMapping
    public List<Producer> listAll() {
        return Producer.getProducers();
    }

    @GetMapping("filter")
    public List<Producer> filter(@RequestParam(required = false) String name) {
        var producers = Producer.getProducers();
        if (name == null || name.isEmpty()) {
            return producers;
        }
        return producers.stream().filter(producer -> producer.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public Producer findById(@PathVariable Long id) {
        return Producer.getProducers().stream().filter(producer -> producer.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "header-obrigatorio")
    public ResponseEntity<ProducerGetResponse> save(@RequestBody ProducerPostRequest producerPostRequest, @RequestHeader HttpHeaders headers) {
        log.info("{}", headers);
        var producer = Producer.builder()
                .id(ThreadLocalRandom.current().nextLong(100_000))
                .name(producerPostRequest.getName())
                .createdAt(LocalDateTime.now()).build();
        Producer.getProducers().add(producer);

        var response = ProducerGetResponse.builder()
                .id(producer.getId())
                .name(producer.getName())
                .createdAt(producer.getCreatedAt())
                .build();
z
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

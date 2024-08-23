package com.marcelomartinsdev.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProducerPostRequest {
    public String name;
    private Long id;
    private LocalDateTime createdAt;
}

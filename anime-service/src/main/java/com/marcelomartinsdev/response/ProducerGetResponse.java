package com.marcelomartinsdev.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProducerGetResponse {
    public String name;
    private Long id;
    private LocalDateTime createdAt;
}

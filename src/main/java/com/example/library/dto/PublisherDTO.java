package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//dto служащее для передачи объекта класса Publisher
@Data
@AllArgsConstructor
public class PublisherDTO {
    private long id;
    private String name;
}

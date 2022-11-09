package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//dto служащее для передачи объекта класса author
@Data
@AllArgsConstructor
public class AuthorDTO {
    private long id;
    private String name;
}

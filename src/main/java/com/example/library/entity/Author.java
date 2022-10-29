package com.example.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("authors")
@Data
@AllArgsConstructor
public class Author {
    @Id
    private long id;
    private String name;
}

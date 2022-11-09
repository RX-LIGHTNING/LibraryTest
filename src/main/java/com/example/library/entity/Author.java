package com.example.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

//Объект для работы с записями таблицы Author, имеет связь многие-ко-многим с таблицей PrintedProduct,
//связь осуществляется с помощью вспомогательного класса AuthorRef.
@Table("AUTHORS")
@Data
@AllArgsConstructor
public class Author {
    @Id
    private long id;
    private String name;
}

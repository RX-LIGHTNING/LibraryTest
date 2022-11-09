package com.example.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

//Объект для работы с записями таблицы Publisher, имеет связь многие-ко-многим с таблицей PrintedProduct,
//связь осуществляется с помощью вспомогательного класса PublisherRef.
@Table("PUBLISHERS")
@Data
@AllArgsConstructor
public class Publisher {
    @Id
    private long id;
    private String name;
}

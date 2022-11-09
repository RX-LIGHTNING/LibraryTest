package com.example.library.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

//Объект для работы с записями таблицы ProductType, имеет связь один-ко-многим с таблицей PrintedProduct.
@Table("PRODUCT_TYPE")
@Data
@AllArgsConstructor
public class ProductType {
    @Id
    private long id;
    private String name;
}

package com.example.library.entity.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

//Объект необходимый для создания связи многие-ко-многим между таблицами Publisher и Product
@Table("PRODUCT_PUBLISHER")
@Data
@AllArgsConstructor
public class PublisherRef {
    private long publisherId;
}

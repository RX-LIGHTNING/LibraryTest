package com.example.library.dto;

import com.example.library.entity.Author;
import com.example.library.entity.PrintedProduct;
import com.example.library.entity.ProductType;
import com.example.library.entity.Publisher;
import com.example.library.entity.ref.AuthorRef;
import com.example.library.entity.ref.PublisherRef;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//dto служащее для передачи объекта класса PrintedProduct, dto передается
//и принимается уже сразу со списками объектов классов Author, Publisher.
//Так же сразу передается и объект класса ProductType. Вся остальная работа(Сохранение и т.д.)
//с ними происходит сервисах.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrintedProductDTO {

    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publishDate;
    private List<Author> authors;
    private List<Publisher> publishers;

    private ProductType productType;
}

package com.example.library.entity;

import com.example.library.entity.ref.AuthorRef;
import com.example.library.entity.ref.PublisherRef;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Объект для работы с записями таблицы PrintedProduct, является "центральным" объектом
//с которым проводятся основные операции в программе
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table("PRINTED_PRODUCTS")
public class PrintedProduct {
    @Id
    private long id;
    @Column("TYPE_ID")
    private long type_id;
    private Set<AuthorRef> authors = new HashSet<>();
    private Set<PublisherRef> publishers = new HashSet<>();
    @Column("NAME")
    private String name;
    @Column("PUBLISHDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publishDate;

    public void addAuthor(Author author) {
        authors.add(new AuthorRef(author.getId()));
    }

    public void addPublisher(Publisher publisher) {
        publishers.add(new PublisherRef(publisher.getId()));
    }
}

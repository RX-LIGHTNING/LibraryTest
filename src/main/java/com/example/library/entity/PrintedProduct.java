package com.example.library.entity;

import com.example.library.entity.ref.AuthorRef;
import com.example.library.entity.ref.PublisherRef;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Table("printed_products")
@Data
@AllArgsConstructor
public class PrintedProduct {
    @Id
    private long id;
    private String name;

    private Set<AuthorRef> authors;
    private Set<PublisherRef> publishers;
    private Date publishDate;
}

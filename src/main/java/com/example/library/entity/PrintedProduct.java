package com.example.library.entity;

import com.example.library.entity.ref.AuthorRef;
import com.example.library.entity.ref.PublisherRef;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Table("PRINTED_PRODUCTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrintedProduct {
    @Id
    private long id;
    private Set<AuthorRef> authors;
    private Set<PublisherRef> publishers;
    @Column("NAME")
    private String name;
    @Column("PUBLISHDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publishDate;
}

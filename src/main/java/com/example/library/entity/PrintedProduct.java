package com.example.library.entity;

import com.example.library.entity.ref.AuthorRef;
import com.example.library.entity.ref.PublisherRef;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public Set<AuthorRef> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorRef> authors) {
        this.authors = authors;
    }

    public Set<PublisherRef> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<PublisherRef> publishers) {
        this.publishers = publishers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

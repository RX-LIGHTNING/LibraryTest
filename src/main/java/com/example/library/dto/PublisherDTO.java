package com.example.library.dto;

//dto служащее для передачи объекта класса Publisher
public class PublisherDTO {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublisherDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

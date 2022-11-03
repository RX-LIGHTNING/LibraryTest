package com.example.library.controller;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.PublisherDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Publisher;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/publisher")
@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping
    public List<PublisherDTO> getAll() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("{id}")
    public PublisherDTO getAuthorById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }

    @PostMapping
    public void postAuthor(Publisher publisher) {
        publisherService.save(publisher);
    }

    @PutMapping("{id}")
    public void putAuthor(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
        publisherService.updatePublisher(id, publisherDTO);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
    }
}

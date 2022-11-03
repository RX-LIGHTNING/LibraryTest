package com.example.library.controller;


import com.example.library.dto.AuthorDTO;
import com.example.library.entity.Author;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/author")
@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAll() {
        return authorService.getAllAuthors();
    }

    @GetMapping("{id}")
    public AuthorDTO getById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public void postAuthor(Author author) {
        authorService.save(author);
    }

    @PutMapping("{id}")
    public void putAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        authorService.updateAuthor(id, authorDTO);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
    }
}

package com.example.library.controller;


import com.example.library.dto.AuthorDTO;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Контроллер предназначенный для работы с Author.
@RequestMapping("/v1/author")
@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    //Get запрос для получения всех авторов
    @GetMapping
    public List<AuthorDTO> getAll() {
        return authorService.getAllAuthors();
    }

    //Get запрос для получения автора по id
    @GetMapping("{id}")
    public AuthorDTO getById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    //Put запрос для изменения уже существующего автора, изменение осуществляется по идентификатору
    @PutMapping("{id}")
    public AuthorDTO putAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return authorService.updateAuthor(id, authorDTO);
    }

    //Delete запрос для удаления существующего по идентификатору
    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
    }
}

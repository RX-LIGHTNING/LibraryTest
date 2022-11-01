package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;

    Author save(Author author){
        if (Objects.isNull(authorRepo.findByName(author.getName()))){
            return authorRepo.save(author);
        }
        else {
            return authorRepo.findByName(author.getName());
        }
    }
}

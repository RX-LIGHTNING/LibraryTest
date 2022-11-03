package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.entity.PrintedProduct;
import com.example.library.dto.AuthorDTO;
import com.example.library.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;

    public Author save(Author author) {
        if (Objects.isNull(authorRepo.findByName(author.getName()))) {
            return authorRepo.save(author);
        } else {
            return authorRepo.findByName(author.getName());
        }
    }

    List<Author> findAllByProduct(PrintedProduct product) {
        return authorRepo.findAllByProductId(product.getId());
    }

    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> temporaryList = new ArrayList<>();
        for (Author item : authorRepo.findAll()) {
            temporaryList.add(new AuthorDTO(item.getId(), item.getName()));
        }
        return temporaryList;
    }

    public AuthorDTO getAuthorById(Long id) {
        return authorRepo.findById(id).map(item -> {
                    return new AuthorDTO(item.getId(), item.getName());
                }
        ).get();
    }

    public void deleteAuthorById(Long id) {
        authorRepo.deleteById(id);
    }

    public void updateAuthor(Long id, AuthorDTO authorDTO) {
       authorRepo.findById(id).map(item -> {
            item.setName(authorDTO.getName());
            return authorRepo.save(item);
        });
    }
}

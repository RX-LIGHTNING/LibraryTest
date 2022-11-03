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

    //В данном методе происходит сохранение объекта класса Author, так же происходит проверка на
    //дубликаты объектов.
    public Author save(Author author) {
        if (Objects.isNull(authorRepo.findByName(author.getName()))) {
            return authorRepo.save(author);
        } else {
            return authorRepo.findByName(author.getName());
        }
    }

    //В данном методе происходит поиск авторов по переданному объекту класса PrintedProduct
    public List<Author> findAllByProduct(PrintedProduct product) {
        return authorRepo.findAllByProductId(product.getId());
    }

    //В данном методе происходит поиск всех авторов, которые существуют в БД. Так же происходит
    //их конвертация в dto
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> temporaryList = new ArrayList<>();
        for (Author item : authorRepo.findAll()) {
            temporaryList.add(new AuthorDTO(item.getId(), item.getName()));
        }
        return temporaryList;
    }

    //Метод предназначенный для поиска автора по идентификатору,  результат выполнения метода конвертируется
    //в dto
    public AuthorDTO getAuthorById(Long id) {
        return authorRepo.findById(id).map(item -> new AuthorDTO(item.getId(), item.getName())
        ).get();
    }

    public void deleteAuthorById(Long id) {
        authorRepo.deleteById(id);
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
       Author author = authorRepo.findById(id).map(item -> {
            item.setName(authorDTO.getName());
            return authorRepo.save(item);
        }).get();
       return new AuthorDTO(author.getId(), author.getName());
    }
}

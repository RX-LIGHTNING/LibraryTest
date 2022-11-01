package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.entity.Publisher;
import com.example.library.repository.AuthorRepo;
import com.example.library.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PublisherService {
    @Autowired
    PublisherRepo publisherRepo;

    Publisher save(Publisher publisher){
            if (Objects.isNull(publisherRepo.findByName(publisher.getName()))){
                return publisherRepo.save(publisher);
            }
            else {
                return publisherRepo.findByName(publisher.getName());
            }
    }
}

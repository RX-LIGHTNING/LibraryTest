package com.example.library.service;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.PublisherDTO;
import com.example.library.entity.Author;
import com.example.library.entity.PrintedProduct;
import com.example.library.entity.Publisher;
import com.example.library.repository.AuthorRepo;
import com.example.library.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PublisherService {
    @Autowired
    PublisherRepo publisherRepo;

    public Publisher save(Publisher publisher) {
        if (Objects.isNull(publisherRepo.findByName(publisher.getName()))) {
            return publisherRepo.save(publisher);
        } else {
            return publisherRepo.findByName(publisher.getName());
        }
    }

    public List<Publisher> findAllByProduct(PrintedProduct product) {
        return publisherRepo.findAllByProductId(product.getId());
    }

    public List<PublisherDTO> getAllPublishers(){
        List<PublisherDTO> temporaryList = new ArrayList<>();
        for (Publisher item : publisherRepo.findAll()) {
            temporaryList.add(new PublisherDTO(item.getId(), item.getName()));
        }
        return temporaryList;
    }

    public PublisherDTO getPublisherById(Long id){
        Publisher publisher = publisherRepo.findById(id).get();
        return new PublisherDTO(publisher.getId(),publisher.getName());
    }

    public void deletePublisherById(Long id){
        publisherRepo.deleteById(id);
    }

    public PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO){
            Publisher publisher = publisherRepo.findById(id).map(item -> {
                item.setId(publisherDTO.getId());
                item.setName(publisherDTO.getName());
                return publisherRepo.save(item);
            }).get();
            return new PublisherDTO(publisher.getId(), publisherDTO.getName());
    }
}

package com.example.library.controller;

import com.example.library.dto.PublisherDTO;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Контроллер предназначенный для работы с объектами класса Publisher(издатель)
@RequestMapping("/v1/publisher")
@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    //get запрос для получения всех издателей
    @GetMapping
    public List<PublisherDTO> getAll() {
        return publisherService.getAllPublishers();
    }

    //get запрос для получения издателя по уникальному идентификатору
    @GetMapping("{id}")
    public PublisherDTO getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }

    //put запрос для изменения издателя по уникальному идентификатору
    @PutMapping("{id}")
    public PublisherDTO putPublisher(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
       return publisherService.updatePublisher(id, publisherDTO);
    }

    //delete запрос для удаления издателя по уникальному идентификатору
    @DeleteMapping("{id}")
    public void deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
    }
}

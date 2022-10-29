package com.example.library.repository;

import com.example.library.entity.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher,Long> {

}

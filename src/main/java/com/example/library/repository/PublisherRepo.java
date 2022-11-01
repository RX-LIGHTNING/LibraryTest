package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Publisher;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PublisherRepo extends CrudRepository<Publisher,Long> {
    @Query("SELECT * FROM PUBLISHERS WHERE name = :name")
    Publisher findByName(@Param("name") String name);
}

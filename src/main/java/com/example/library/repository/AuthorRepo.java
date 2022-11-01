package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.ProductType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorRepo extends CrudRepository<Author,Long> {
    @Query("SELECT * FROM AUTHORS WHERE name = :name")
    Author findByName(@Param("name") String name);
}

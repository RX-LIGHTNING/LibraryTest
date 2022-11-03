package com.example.library.repository;

import com.example.library.entity.Author;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepo extends CrudRepository<Author, Long> {
    //Запрос для поиска автора по имени
    @Query("SELECT * FROM AUTHORS WHERE name = :name")
    Author findByName(@Param("name") String name);

    //Запрос для поиска автора по идентификатору продукции
    @Query("SELECT T1.* FROM AUTHORS as T1 INNER JOIN PRODUCT_AUTHOR as T2 ON T1.ID = T2.AUTHOR_ID WHERE T2.PRINTED_PRODUCT = :ProdId")
    List<Author> findAllByProductId(@Param("ProdId") Long id);
}

package com.example.library.repository;

import com.example.library.entity.Publisher;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
    //Запрос для поиска издателя по имени
    @Query("SELECT * FROM PUBLISHERS WHERE name = :name")
    Publisher findByName(@Param("name") String name);

    //Запрос для поиска издателя по идентификатору продукции
    @Query("SELECT T1.* FROM PUBLISHERS as T1 INNER JOIN PRODUCT_PUBLISHER as T2 ON T1.ID = T2.PUBLISHER_ID WHERE T2.PRINTED_PRODUCT = :ProdId")
    List<Publisher> findAllByProductId(@Param("ProdId") Long id);
}

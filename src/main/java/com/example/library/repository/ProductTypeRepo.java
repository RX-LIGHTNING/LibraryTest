package com.example.library.repository;

import com.example.library.entity.ProductType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductTypeRepo extends CrudRepository<ProductType, Long> {
    //Запрос для поиска типа продукта по названию типа
    @Query("SELECT * FROM PRODUCT_TYPE WHERE name = :name")
    ProductType findByName(@Param("name") String name);

    //Запро для поиска типа продукта по идентификатору самого продукта
    @Query("SELECT * FROM PRODUCT_TYPE as t1 WHERE t1.id = :typeId")
    ProductType findByProduct(@Param("typeId") Long id);
}

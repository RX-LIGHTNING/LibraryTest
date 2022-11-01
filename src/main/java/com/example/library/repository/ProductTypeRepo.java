package com.example.library.repository;

import com.example.library.entity.ProductType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductTypeRepo extends CrudRepository<ProductType,Long> {
    @Query("SELECT * FROM PRODUCT_TYPE WHERE name = :name")
    ProductType findByName(@Param("name") String name);
}

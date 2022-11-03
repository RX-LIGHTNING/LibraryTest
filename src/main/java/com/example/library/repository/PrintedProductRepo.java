package com.example.library.repository;

import com.example.library.entity.PrintedProduct;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrintedProductRepo extends CrudRepository<PrintedProduct,Long> {

    @Query("SELECT T1.* FROM PRINTED_PRODUCTS AS T1 " +
            "INNER JOIN PRODUCT_AUTHOR AS T2 ON T1.ID = T2.AUTHOR_ID " +
            "INNER JOIN AUTHORS AS T3 ON T2.AUTHOR_ID = T3.ID " +
            "WHERE T3.NAME = :name")
    List<PrintedProduct> findAllByAuthorsName(@Param("name") String authorName);

    @Query("SELECT T1.* FROM PRINTED_PRODUCTS AS T1 " +
            "INNER JOIN PRODUCT_PUBLISHER AS T2 ON T1.ID = T2.PUBLISHER_ID " +
            "INNER JOIN PUBLISHERS AS T3 ON T2.PUBLISHER_ID = T3.ID " +
            "WHERE T3.NAME = :name")
    List<PrintedProduct> findAllByPublisherName(@Param("name") String publisherName);

    @Query("SELECT T1.* FROM PRINTED_PRODUCTS AS T1" +
            " INNER JOIN PRODUCT_TYPE AS T2 ON T1.TYPE_ID = T2.id" +
            " WHERE T2.name = :name")
    List<PrintedProduct> findAllByTypeName(@Param("name") String typeName);

    @Query("SELECT * FROM PRINTED_PRODUCTS WHERE NAME=:name")
    List<PrintedProduct> findAllByProductName(@Param("name") String Name);
}

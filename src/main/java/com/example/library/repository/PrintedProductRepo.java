package com.example.library.repository;

import com.example.library.entity.PrintedProduct;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrintedProductRepo extends CrudRepository<PrintedProduct,Long> {


    //SQL запрос для получения всей печатной продукции по имени автора
    @Query("SELECT T1.* FROM PRINTED_PRODUCTS AS T1 " +
            "INNER JOIN PRODUCT_AUTHOR AS T2 ON T1.ID = T2.PRINTED_PRODUCT " +
            "INNER JOIN AUTHORS AS T3 ON T2.AUTHOR_ID = T3.ID " +
            "WHERE upper(T3.NAME) = upper(:name)")
    List<PrintedProduct> findAllByAuthorsName(@Param("name") String authorId);

    //SQL запрос для получения всей печатной продукции по названию издательства
    @Query("SELECT T1.* FROM PRINTED_PRODUCTS AS T1 " +
            "INNER JOIN PRODUCT_PUBLISHER AS T2 ON T1.ID = T2.PRINTED_PRODUCT " +
            "INNER JOIN PUBLISHERS AS T3 ON T2.PUBLISHER_ID = T3.ID " +
            "WHERE upper(T3.NAME) = upper(:name)")
    List<PrintedProduct> findAllByPublisherName(@Param("name") String publisherName);

    //SQL запрос для получения всей печатной продукции по названию типа
    @Query("SELECT T1.* FROM PRINTED_PRODUCTS AS T1" +
            " INNER JOIN PRODUCT_TYPE AS T2 ON T1.TYPE_ID = T2.id" +
            " WHERE upper(T2.name) = upper(:name)")
    List<PrintedProduct> findAllByTypeName(@Param("name") String typeName);

    //SQL запрос для получения всей печатной продукции по дате публикации
    @Query("SELECT * FROM PRINTED_PRODUCTS WHERE PUBLISHDATE = :date")
    List<PrintedProduct> findAllByDate(@Param("date") String date);

    //SQL запрос для получения всей печатной продукции по названию продукции
    @Query("SELECT * FROM PRINTED_PRODUCTS WHERE NAME=:name")
    List<PrintedProduct> findAllByProductName(@Param("name") String Name);
}

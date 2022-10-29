package com.example.library.repository;

import com.example.library.entity.PrintedProduct;
import org.springframework.data.repository.CrudRepository;

public interface PrintedProductRepo extends CrudRepository<PrintedProduct,Long> {

}

package com.example.library.service;

import com.example.library.entity.ProductType;
import com.example.library.repository.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductTypeService {
    @Autowired
    ProductTypeRepo productTypeRepo;

    ProductType save(ProductType productType){
        if (Objects.isNull(productTypeRepo.findByName(productType.getName()))){
            return productTypeRepo.save(productType);
        }
        else {
            return productTypeRepo.findByName(productType.getName());
        }
    }
}

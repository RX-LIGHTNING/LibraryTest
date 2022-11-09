package com.example.library.service;

import com.example.library.entity.PrintedProduct;
import com.example.library.entity.ProductType;
import com.example.library.repository.ProductTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductTypeService {
    private final ProductTypeRepo productTypeRepo;

    //Метод для сохранения нового объекта класса ProductType, так же в методе происходит проверка на
    //дубликаты
    ProductType save(ProductType productType) {
        if (Objects.isNull(productTypeRepo.findByName(productType.getName()))) {
            return productTypeRepo.save(productType);
        } else {
            return productTypeRepo.findByName(productType.getName());
        }
    }

    //Метод для поиска ProductType по PrintedProduct
    public ProductType findByProduct(PrintedProduct product) {
        return productTypeRepo.findByProduct(product.getType_id());
    }

}

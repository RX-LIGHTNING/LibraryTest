package com.example.library.service;

import com.example.library.entity.PrintedProduct;
import com.example.library.entity.dto.PrintedProductDTO;
import com.example.library.repository.PrintedProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PrintedProductService {
@Autowired
    PrintedProductRepo productRepo;

    public Iterable<PrintedProduct> getAllProducts() {
        return productRepo.findAll();
    }

    public PrintedProduct getProductById(Long id) {
        return productRepo.findById(id).orElseThrow();
    }

    public PrintedProduct updateProduct(Long id, PrintedProductDTO product){
        PrintedProduct updatedProduct = productRepo.findById(id)
                .map(item -> {
                   item.setName(product.getName());
                   item.setAuthors(product.getAuthors());
                   item.setPublishDate(product.getPublishDate());
                   item.setPublishers(product.getPublishers());
                    return productRepo.save(item);
                }).orElseThrow(
                //Здесь мог быть ваш эксепшен
                );
        return productRepo.findById(id).get();
    }

    public PrintedProduct saveProduct(PrintedProduct product) {

        return productRepo.save(product);
    }

    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

}

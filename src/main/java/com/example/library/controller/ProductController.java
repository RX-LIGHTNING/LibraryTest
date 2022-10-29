package com.example.library.controller;

import com.example.library.entity.PrintedProduct;
import com.example.library.service.PrintedProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    @Autowired
    PrintedProductService productService;

    @GetMapping
    public Iterable<PrintedProduct> get() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public PrintedProduct getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public PrintedProduct post(PrintedProduct product) {
        return productService.saveProduct(product);
    }
    @PutMapping("{id}")
    public PrintedProduct put(@PathVariable Long id, @RequestBody PrintedProduct product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}

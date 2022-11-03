package com.example.library.controller;

import com.example.library.entity.PrintedProduct;
import com.example.library.dto.PrintedProductDTO;
import com.example.library.service.PrintedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/product")
@RestController
public class ProductController {

    @Autowired
    PrintedProductService productService;

    @GetMapping
    public List<PrintedProductDTO> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public PrintedProductDTO getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public void post(@RequestBody PrintedProductDTO product) {
        productService.saveProduct(product);
    }

    @PutMapping("{id}")
    public PrintedProduct put(@PathVariable Long id, @RequestBody PrintedProductDTO product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}

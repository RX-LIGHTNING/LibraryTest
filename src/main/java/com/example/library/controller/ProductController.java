package com.example.library.controller;

import com.example.library.entity.PrintedProduct;
import com.example.library.dto.PrintedProductDTO;
import com.example.library.service.PrintedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Контроллер предназначенный для работы с объектами PrintedProduct
@RequestMapping("/v1/product")
@RestController
public class ProductController {

    @Autowired
    PrintedProductService productService;

    //get запрос для получения всех объектов класса PrintedProduct
    @GetMapping
    public List<PrintedProductDTO> getAll() {
        return productService.getAllProducts();
    }

    //get запрос для получения всех объектов класса PrintedProduct, которые соответствуют фильтру
    @GetMapping("/filter")
    public List<PrintedProductDTO> getAllByFilter(@RequestParam("field") String field,
                                                  @RequestParam("value") String value) {
        return productService.getProductsByFilter(field, value);
    }

    //get запрос для получения объекта класса PrintedProduct по уникальному id
    @GetMapping("{id}")
    public PrintedProductDTO getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //Post запрос для добавления нового объекта класса PrintedProduct.
    @PostMapping
    public void post(@RequestBody PrintedProductDTO product) {
        productService.saveProduct(product);
    }

    //Put запрос для изменения уже существующего объекта класса PrintedProduct по уникальному id
    @PutMapping("{id}")
    public PrintedProduct put(@PathVariable Long id, @RequestBody PrintedProductDTO product) {
        return productService.updateProduct(id, product);
    }

    //Delete запрос для удаления объекта печатной продукции по уникальному идентификатору
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}

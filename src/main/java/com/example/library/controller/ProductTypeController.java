package com.example.library.controller;

import com.example.library.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/producttype")
@RestController
public class ProductTypeController {

    @Autowired
    ProductTypeService typeService;

}

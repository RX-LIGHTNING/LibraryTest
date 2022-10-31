package com.example.library.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("PRODUCT_TYPE")
public class ProductType {
    @Id
    private long id;
    private String name;
    @MappedCollection(idColumn = "type_id")
    private Set<PrintedProduct> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PrintedProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<PrintedProduct> products) {
        this.products = products;
    }
}

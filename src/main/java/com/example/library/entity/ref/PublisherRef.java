package com.example.library.entity.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("product_publisher")
@Data
@AllArgsConstructor
public class PublisherRef {
    private long publisherId;
}

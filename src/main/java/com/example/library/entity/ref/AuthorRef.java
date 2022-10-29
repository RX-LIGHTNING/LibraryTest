package com.example.library.entity.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("product_author")
@Data
@AllArgsConstructor
public class AuthorRef {
    private long authorId;
}

package com.example.library.entity.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCT_AUTHOR")
@Data
@AllArgsConstructor
public class AuthorRef {
    @Column("AUTHOR_ID")
    private long authorId;
}

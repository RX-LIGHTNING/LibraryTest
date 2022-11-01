package com.example.library.entity.ref;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("PRODUCT_AUTHOR")
public class AuthorRef {
    @Column("AUTHOR_ID")
    private long authorId;

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public AuthorRef(long authorId) {
        this.authorId = authorId;
    }
}

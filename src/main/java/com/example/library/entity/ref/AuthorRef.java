package com.example.library.entity.ref;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

//Объект необходимый для создания связи многие-ко-многим между таблицами Author и Product
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorRef authorRef = (AuthorRef) o;
        return authorId == authorRef.authorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }
}

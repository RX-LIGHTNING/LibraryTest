package com.example.library.entity.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

//Объект необходимый для создания связи многие-ко-многим между таблицами Publisher и Product
@Table("PRODUCT_PUBLISHER")
public class PublisherRef {
    private long publisherId;

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public PublisherRef(long publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublisherRef that = (PublisherRef) o;
        return publisherId == that.publisherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId);
    }
}

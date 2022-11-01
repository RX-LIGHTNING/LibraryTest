package com.example.library.entity.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

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
}

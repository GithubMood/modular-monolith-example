package com.monolith.example.common.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
public class AbstractEntity<T> {
    @Id
    protected T id;
    @Field
    protected LocalDateTime createdAt;
    @Field
    protected LocalDateTime lastModifiedAt;
}

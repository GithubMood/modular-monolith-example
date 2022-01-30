package com.monolith.example.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@Accessors(chain = true)
public class AbstractEntity<T> {
    @Id
    protected T id;
    @Field
    @CreatedDate
    protected LocalDateTime createdAt;
    @Field
    @LastModifiedDate
    protected LocalDateTime lastModifiedAt;
}

package com.monolith.example.author.impl.integration.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document("author")
public class AuthorEntity {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private int age;

    @Field
    @CreatedDate
    private LocalDateTime createdAt;

    @Field
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}

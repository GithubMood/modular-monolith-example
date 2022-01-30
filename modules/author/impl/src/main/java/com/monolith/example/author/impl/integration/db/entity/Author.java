package com.monolith.example.author.impl.integration.db.entity;

import com.monolith.example.common.entity.AbstractEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@Document("author")
public class Author extends AbstractEntity<String> {
    @Field
    String name;

    @Field
    int age;
}

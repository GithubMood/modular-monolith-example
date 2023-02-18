package com.monolith.example.integratoin.test.config.annotation.slices;

import com.monolith.example.MongoConfig;
import com.monolith.example.integratoin.test.config.annotation.MongoTestConfig;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DataMongoTest
@MongoTestConfig
@Import(MongoConfig.class)
public @interface MongoTest {
}

package com.monolith.example.integratoin.test.config.annotation.slices;

import com.monolith.example.MongoConfig;
import com.monolith.example.integratoin.test.config.initializer.MongoContainerInitializer;
import com.monolith.example.integratoin.test.extension.MongoCleanDatabaseExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DataMongoTest
@ContextConfiguration(initializers = {MongoContainerInitializer.class})
@ExtendWith(MongoCleanDatabaseExtension.class)
@Import(MongoConfig.class)
public @interface MongoTest {
}

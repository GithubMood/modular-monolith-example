package com.monolith.example.integratoin.test.config.annotation;

import com.monolith.example.integratoin.test.config.initializer.MongoContainerInitializer;
import com.monolith.example.integratoin.test.extension.MongoCleanDatabaseExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ContextConfiguration(initializers = {MongoContainerInitializer.class})
@ExtendWith(MongoCleanDatabaseExtension.class)
public @interface MongoTestConfig {
}

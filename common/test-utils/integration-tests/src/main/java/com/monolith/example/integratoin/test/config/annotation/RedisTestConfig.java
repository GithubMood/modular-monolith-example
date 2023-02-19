package com.monolith.example.integratoin.test.config.annotation;

import com.monolith.example.integratoin.test.config.initializer.RedisContainerInitializer;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ContextConfiguration(initializers = {RedisContainerInitializer.class})
public @interface RedisTestConfig {
}

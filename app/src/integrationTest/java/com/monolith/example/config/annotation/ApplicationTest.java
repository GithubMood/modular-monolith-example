package com.monolith.example.config.annotation;

import com.monolith.example.integratoin.test.config.annotation.slices.FullContextTest;
import com.monolith.example.integratoin.test.config.initializer.MongoContainerInitializer;
import com.monolith.example.integratoin.test.config.initializer.RedisContainerInitializer;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@FullContextTest(
        initializers = {
                MongoContainerInitializer.class,
                RedisContainerInitializer.class
        }
)
@ActiveProfiles("test")
public @interface ApplicationTest {
}

package com.monolith.example.integratoin.test.config.annotation.slices;

import com.monolith.example.integratoin.test.config.initializer.MongoContainerInitializer;
import com.monolith.example.integratoin.test.extension.JsonUtilsExtension;
import com.monolith.example.integratoin.test.extension.MongoCleanDatabaseExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(JsonUtilsExtension.class)
@ExtendWith(MongoCleanDatabaseExtension.class)
@ContextConfiguration
public @interface FullContextTest {
    @AliasFor(annotation = ContextConfiguration.class, attribute = "initializers")
    Class<? extends ApplicationContextInitializer<?>>[] initializers() default MongoContainerInitializer.class;

}

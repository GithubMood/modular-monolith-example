package com.monolith.example.integratoin.test.config.annotation.slices;

import com.monolith.example.integratoin.test.config.annotation.MongoTestConfig;
import com.monolith.example.integratoin.test.extension.JsonUtilsExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@MongoTestConfig
@ExtendWith(JsonUtilsExtension.class)
public @interface ApplicationTest {
}

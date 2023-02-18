package com.monolith.example.integratoin.test.config.annotation.slices;

import com.monolith.example.integratoin.test.extension.JsonUtilsExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(JsonUtilsExtension.class)
public @interface RestControllerTest {
    @AliasFor(annotation = WebMvcTest.class, attribute = "controllers")
    Class<?>[] value() default {};
}

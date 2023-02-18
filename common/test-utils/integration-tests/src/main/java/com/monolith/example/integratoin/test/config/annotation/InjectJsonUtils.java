package com.monolith.example.integratoin.test.config.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface InjectJsonUtils {
}

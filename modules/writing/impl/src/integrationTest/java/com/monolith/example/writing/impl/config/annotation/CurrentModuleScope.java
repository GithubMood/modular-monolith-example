package com.monolith.example.writing.impl.config.annotation;

import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ActiveProfiles({"common", "test", "writing"})
public @interface CurrentModuleScope {
}

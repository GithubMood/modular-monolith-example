package com.monolith.example.iam.impl.config.annotation;

import com.monolith.example.integratoin.test.config.annotation.slices.FullContextTest;
import com.monolith.example.integratoin.test.config.initializer.MongoContainerInitializer;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@FullContextTest(initializers = {MongoContainerInitializer.class})
@CurrentModuleScope
public @interface CurrentModuleTest {
}

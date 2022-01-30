package com.monolith.example.integratoin.test.config.initializer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MongoDBContainer;

public class MongoContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:4.4.4")
            .withExposedPorts(27017)
            .withLabel("group", "monolith");

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        mongoDbContainer.start();

        TestPropertyValues.of(
                "spring.data.mongodb.uri=" + mongoDbContainer.getReplicaSetUrl()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}

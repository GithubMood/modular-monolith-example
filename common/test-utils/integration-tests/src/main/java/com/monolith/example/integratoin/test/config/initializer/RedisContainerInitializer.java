package com.monolith.example.integratoin.test.config.initializer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class RedisContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final int REDIS_PORT = 6379;

    private static final GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:7.0"))
            .withExposedPorts(REDIS_PORT)
            .withLabel("group", "monolith");

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        redis.start();

        var host = redis.getHost();
        var port = redis.getMappedPort(REDIS_PORT);
        TestPropertyValues.of("spring.redis.host=" + host,
                        "spring.redis.port=" + port)
                .applyTo(configurableApplicationContext.getEnvironment());
    }
}

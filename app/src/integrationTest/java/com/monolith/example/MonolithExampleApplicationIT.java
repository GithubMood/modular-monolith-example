package com.monolith.example;

import com.monolith.example.integratoin.test.config.annotation.RedisTestConfig;
import com.monolith.example.integratoin.test.config.annotation.slices.ApplicationTest;
import org.junit.jupiter.api.Test;

@RedisTestConfig
@ApplicationTest
class MonolithExampleApplicationIT {
    @Test
    void applicationStarts() {
    }
}

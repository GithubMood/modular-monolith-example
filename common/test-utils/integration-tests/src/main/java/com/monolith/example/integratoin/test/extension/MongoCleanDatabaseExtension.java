package com.monolith.example.integratoin.test.extension;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class MongoCleanDatabaseExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        ApplicationContext springContext = SpringExtension.getApplicationContext(extensionContext);
        springContext.getBeansOfType(MongoRepository.class).values()
                .forEach(CrudRepository::deleteAll);
    }
}

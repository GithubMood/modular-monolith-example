package com.monolith.example.integratoin.test.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monolith.example.integratoin.test.config.annotation.InjectJsonUtils;
import com.monolith.example.integratoin.test.utils.JsonUtils;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class JsonUtilsExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        ApplicationContext springContext = SpringExtension.getApplicationContext(extensionContext);
        var objectMapper = springContext.getBean(ObjectMapper.class);

        var testInstance = extensionContext.getTestInstance()
                .orElseThrow(() -> new IllegalStateException("Test Instance is not present"));

        ReflectionUtils.retrieveClassFieldsWithAnnotation(testInstance.getClass(), InjectJsonUtils.class)
                .forEach(field -> ReflectionUtils.setFieldValue(testInstance, field, JsonUtils.withConfiguredMapper(objectMapper)));
    }
}

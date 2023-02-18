package com.monolith.example.integratoin.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonUtils {
    private final ObjectMapper objectMapper;

    public String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Unable to convert object [%s] to json".formatted(object), e);
        }
    }

    public static JsonUtils withDefaultMapper() {
        return new JsonUtils(new ObjectMapper());
    }

    public static JsonUtils withConfiguredMapper(ObjectMapper objectMapper) {
        return new JsonUtils(objectMapper);
    }
}

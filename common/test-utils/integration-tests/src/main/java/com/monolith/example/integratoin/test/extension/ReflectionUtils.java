package com.monolith.example.integratoin.test.extension;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Slf4j
@UtilityClass
public class ReflectionUtils {
    public <T extends Annotation> List<Field> retrieveClassFieldsWithAnnotation(Class<? extends Object> aClass, Class<T> annotationType) {
        return retrieveAllClassFields(aClass).stream()
                .filter(field -> field.getAnnotation(annotationType) != null)
                .collect(Collectors.toList());
    }

    public List<Field> retrieveAllClassFields(Class<? extends Object> aClass) {
        List<Field> allFields = new ArrayList<>();
        Field[] declaredFields = aClass.getDeclaredFields();
        allFields.addAll(asList(declaredFields));
        Type genericSuperclass = aClass.getGenericSuperclass();
        while (!genericSuperclass.equals(Object.class)) {
            allFields.addAll(asList(((Class) genericSuperclass).getDeclaredFields()));
            genericSuperclass = genericSuperclass.getClass().getGenericSuperclass();
        }
        return allFields;
    }

    public <T> T getFieldValue(Object object, Field field, Class<T> type) {
        try {
            field.setAccessible(true);
            return type.cast(field.get(object));
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to get value from field " + field);
        }
    }

    public void setFieldValue(Object targetObject, Field field, Object fieldValue) {
        try {
            boolean accessible = field.canAccess(targetObject);
            if (field.trySetAccessible()) {
                field.set(targetObject, fieldValue);
                field.setAccessible(accessible);
            } else {
                //throwing to catch it below
                throw new IllegalAccessException();
            }
        } catch (IllegalAccessException e) {
            String errorMessage = String.format("Unable to set value [%s] to the field [%s] of the object [%s]",
                    fieldValue, field.getName(), targetObject.getClass().getName());
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

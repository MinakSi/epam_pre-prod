package com.epam.rd.Serhii_Minakov.Task7.part1.input;

import com.epam.rd.Serhii_Minakov.Task7.part1.Localization;
import com.epam.rd.Serhii_Minakov.Task7.part1.models.Goods;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AnnotationHelper {

    private final Class<? extends Goods> goodClass;

    public AnnotationHelper(Class<? extends Goods> goodClass) {
        this.goodClass = goodClass;
    }

    /**
     * Finds a key value from field annotation
     *
     * @param fieldName name of the field annotated with Localization annotation
     * @return a key value from field annotation;
     * null if there is no field in this class and its superclasses;
     * null if the field is not annotated with Localization annotation;
     */
    public String getKeyFromAnnotation(String fieldName) {
        Field field = getFieldByFieldName(fieldName);
        if (field == null) {
            return null;
        }
        Localization annotation = field.getAnnotation(Localization.class);
        if (annotation == null) {
            return null;
        }
        return annotation.key();
    }

    private Field getFieldByFieldName(String fieldName) {
        Optional<Field> field = getAllFieldsFromGoodClass().stream()
                .filter(x -> x.getName().equals(fieldName))
                .findFirst();
        return field.orElse(null);
    }

    private List<Field> getAllFieldsFromGoodClass() {
        List<Field> fields = new ArrayList<>();
        getAllParents().forEach(x -> fields.addAll(Arrays.asList(x.getDeclaredFields())));
        return fields;
    }

    private List<Class<?>> getAllParents() {
        List<Class<?>> parents = new ArrayList<>();
        for (Class<?> c = goodClass; c != null; c = c.getSuperclass()) {
            parents.add(c);
        }
        return parents;
    }
}

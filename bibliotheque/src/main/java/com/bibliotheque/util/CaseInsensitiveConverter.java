package com.bibliotheque.util;

import java.beans.PropertyEditorSupport;

public class CaseInsensitiveConverter<T extends Enum<T>> extends PropertyEditorSupport {

    private final Class<T> typeParameterClass;

    public CaseInsensitiveConverter(Class<T> typeParameterClass) {
        super();
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public void setAsText(final String text) throws IllegalArgumentException {
        String upper = text.toUpperCase(); // or something more robust
        T value = T.valueOf(typeParameterClass, upper);
        setValue(value);
    }
}
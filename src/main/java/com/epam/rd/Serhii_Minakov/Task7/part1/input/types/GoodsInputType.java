package com.epam.rd.Serhii_Minakov.Task7.part1.input.types;

import java.util.Locale;

/**
 * This interface defines an input type
 */
public interface GoodsInputType {

    String BASE_STRING = "string";
    String BASE_INT = "int";
    String BASE_DOUBLE = "double";

    String getString(String key);

    int getInt(String key);

    double getDouble(String key);

    boolean getBoolean(String key);

    void setLocale(Locale locale);
}

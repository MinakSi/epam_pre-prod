package com.epam.rd.Serhii_Minakov.Task7.part1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Localization annotation is created to annotate fields which names will be printed for user.
 * The annotation has a key value with the help of which it is possible to get localized name of the field from properties.
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Localization {

    String key();
}

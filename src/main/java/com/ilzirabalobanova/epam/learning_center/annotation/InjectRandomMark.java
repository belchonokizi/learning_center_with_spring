package com.ilzirabalobanova.epam.learning_center.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomMark {

    int minValue() default 1;

    int maxValue() default 100;
}

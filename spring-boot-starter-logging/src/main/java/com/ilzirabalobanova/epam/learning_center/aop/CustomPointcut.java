package com.ilzirabalobanova.epam.learning_center.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class CustomPointcut extends DynamicMethodMatcherPointcut {
    private final LoggingProperties properties;

    @Autowired
    public CustomPointcut(LoggingProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return properties.getMethods().stream().map(m -> m.equals(method.getName()))
                .findFirst().orElse(false);
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> properties.getPackages().stream().map(p -> clazz.getPackage().getName().contains(p))
                .findFirst().orElse(false);
    }
}

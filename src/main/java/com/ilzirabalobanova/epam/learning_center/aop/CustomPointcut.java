package com.ilzirabalobanova.epam.learning_center.aop;

import com.ilzirabalobanova.epam.learning_center.util.parser.YamlParser;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.List;

public class CustomPointcut extends DynamicMethodMatcherPointcut {
    private final YamlParser parser;

    public CustomPointcut(YamlParser parser) {
        this.parser = parser;
    }

    private LoggingProperties getLoggingPropertiesObject() {
        return parser.getContent("src/main/resources/application.yaml");
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        List<String> methodsToLog = getLoggingPropertiesObject().getMethods();
        for (String methodName : methodsToLog) {
            if (method.getName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        List<String> packagesToLog = getLoggingPropertiesObject().getPackages();

        return clazz -> {
            for (String packageName : packagesToLog) {
                if (clazz.getPackage().getName().contains(packageName)) {
                    return true;
                }
            }
            return false;
        };
    }
}

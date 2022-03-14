package com.ilzirabalobanova.epam.learning_center.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class LearningCenterLoggingAspect implements MethodInterceptor {

    private final Logger log = LoggerFactory.getLogger(LearningCenterLoggingAspect.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object retObject = invocation.proceed();
        List<Object> arguments = Arrays.asList(invocation.getArguments());
        log.info("Возвращаемый объект - {}. Аргументы метода - {}. Стартер", retObject, arguments);
        return retObject;
    }
}

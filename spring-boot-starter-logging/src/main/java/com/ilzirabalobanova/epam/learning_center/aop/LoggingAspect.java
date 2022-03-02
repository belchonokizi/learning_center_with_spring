package com.ilzirabalobanova.epam.learning_center.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Aspect
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private LoggingProperties properties;

    @Pointcut(value = "execution(public void add*(*))")
    public void addMethodPointcut() {
    }

    @After("addMethodPointcut()")
    public void afterAddMethodAdvice(JoinPoint joinPoint) {
        List<Object> objects = Arrays.asList(joinPoint.getArgs());
        objects.forEach(s -> log.info("{} добавлен", s));
    }

    @Pointcut(value =
            "execution(public * delete*(*))")
    public void deleteStudentMethodPointcut() {
    }

    @AfterReturning(value = "deleteStudentMethodPointcut()", returning = "returnObject")
    public void afterDeleteStudentMethodAdvice(Object returnObject) {
        if (returnObject != null) {
            log.info("{} удален", returnObject);
        }
    }

    @Pointcut(value =
            "execution(public * sortAndShow*(..))")
    public void sortAndShowStudentsMethodPointcut() {
    }

    @AfterReturning(value = "sortAndShowStudentsMethodPointcut()", returning = "returnObject")
    public void afterSortAndShowStudentsMethodPointcutMethodAdvice(JoinPoint joinPoint, Object returnObject) {
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        args.forEach(arg -> log.info("\nПараметр метода {}", arg));
        if (returnObject != null) {
            log.info("\nВозвращаемый объект: \n{}", returnObject);
        }
    }


}

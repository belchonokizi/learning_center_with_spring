package com.ilzirabalobanova.epam.learning_center.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut(value = "execution(public void com.ilzirabalobanova.epam.learning_center.service.impl.StudentService.addStudent(*))")
    public void addMethodPointcut() {
    }

    @After("addMethodPointcut()")
    public void afterAddMethodAdvice(JoinPoint joinPoint) {
        List<Object> objects = Arrays.asList(joinPoint.getArgs());
        objects.forEach(s -> log.info("{} добавлен", s));
    }

    @Pointcut(value =
            "execution(public * com.ilzirabalobanova.epam.learning_center.service.impl.StudentService.deleteStudent(*))")
    public void deleteStudentMethodPointcut() {
    }

    @AfterReturning(value = "deleteStudentMethodPointcut()", returning = "returnObject")
    public void afterDeleteStudentMethodAdvice(Object returnObject) {
        if (returnObject != null) {
            log.info("{} удален", returnObject);
        }
    }

    @Pointcut(value =
            "execution(public * com.ilzirabalobanova.epam.learning_center.service.impl.StudentService.sortAndShowStudents(..))")
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

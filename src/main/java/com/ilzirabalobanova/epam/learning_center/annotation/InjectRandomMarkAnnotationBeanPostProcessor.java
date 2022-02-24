package com.ilzirabalobanova.epam.learning_center.annotation;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class InjectRandomMarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            InjectRandomMark annotation = method.getAnnotation(InjectRandomMark.class);
            if (annotation != null) {
                int minMark = annotation.minValue();
                int maxMark = annotation.maxValue();
                Map<String, Integer> newMarks = new HashMap<>();
                Student student = (Student) bean;
                for (Map.Entry<String, Integer> pair : student.getMarksMap().entrySet()) {
                    Integer newMark = ThreadLocalRandom.current().nextInt(minMark, maxMark + 1);
                    newMarks.put(pair.getKey(), newMark);
                }
                ReflectionUtils.invokeMethod(method, bean, newMarks);
                break;
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

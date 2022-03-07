package com.ilzirabalobanova.epam.learning_center.annotation;

import com.ilzirabalobanova.epam.learning_center.bean.StudentBean;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class InjectRandomMarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomMark annotation = field.getAnnotation(InjectRandomMark.class);
            if (annotation != null) {
                int minMark = annotation.minValue();
                int maxMark = annotation.maxValue();
                List<Integer> newList = new ArrayList<>();
                StudentBean student = (StudentBean) bean;
                student.setModuleCount(ThreadLocalRandom.current().nextInt(2, 6));
                for (int i = 1; i < student.getModuleCount(); i++) {
                    int newMark = ThreadLocalRandom.current().nextInt(minMark, maxMark + 1);
                    newList.add(newMark);
                }
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, bean, newList);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

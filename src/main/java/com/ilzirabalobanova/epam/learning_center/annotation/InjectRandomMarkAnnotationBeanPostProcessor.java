package com.ilzirabalobanova.epam.learning_center.annotation;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class InjectRandomMarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final IProgramService programService;

    @Autowired
    public InjectRandomMarkAnnotationBeanPostProcessor(IProgramService programService) {
        this.programService = programService;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomMark annotation = field.getAnnotation(InjectRandomMark.class);
            if (annotation != null) {
                int minMark = annotation.minValue();
                int maxMark = annotation.maxValue();
                Map<String, Integer> newMarks = new HashMap<>();
                Student student = (Student) bean;
                List<Module> modules = programService.findProgramById(student.getProgramId()).getModules();
                for (Module module : modules) {
                    int newMark = ThreadLocalRandom.current().nextInt(minMark, maxMark + 1);
                    newMarks.put(module.getName(), newMark);
                }
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, newMarks);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

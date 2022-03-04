//package com.ilzirabalobanova.epam.learning_center.aop;
//
//import org.springframework.aop.ClassFilter;
//import org.springframework.aop.support.DynamicMethodMatcherPointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.lang.reflect.Method;
//import java.util.List;
//
//public class CustomPointcut extends DynamicMethodMatcherPointcut {
//    private final LoggingProperties properties;
//
//    @Autowired
//    public CustomPointcut(LoggingProperties properties) {
//        this.properties = properties;
//    }
//
//    @Override
//    public boolean matches(Method method, Class<?> targetClass, Object... args) {
//        List<String> methodsToLog = properties.getMethods();
//        for (String methodName : methodsToLog) {
//            if (method.getName().equals(methodName)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public ClassFilter getClassFilter() {
//        List<String> packagesToLog = properties.getPackages();
//
//        return clazz -> {
//            for (String packageName : packagesToLog) {
//                if (clazz.getPackage().getName().contains(packageName)) {
//                    return true;
//                }
//            }
//            return false;
//        };
//    }
//}

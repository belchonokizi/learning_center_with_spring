package com.ilzirabalobanova.epam.learning_center.aop;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoggingProperties {
    private List<String> packages;
    private List<String> methods;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }
}

package com.ilzirabalobanova.epam.learning_center.aop;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@ConfigurationProperties(prefix = "logging.loggable")
public class LoggingProperties {
    @NotEmpty
    private List<String> packages;

    @NotEmpty
    private Set<String> methods;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    public Set<String> getMethods() {
        return methods;
    }

    public void setMethods(Set<String> methods) {
        this.methods = methods;
    }
}

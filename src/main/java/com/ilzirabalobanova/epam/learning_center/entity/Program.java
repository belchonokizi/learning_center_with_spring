package com.ilzirabalobanova.epam.learning_center.entity;

import lombok.Data;
import java.util.List;
import java.util.Objects;

@Data
public class Program {
    private int id;
    private String name;
    private List<Module> modules;


    public Program() {
    }

    public Program(int id) {
        this.id = id;
    }

    public Program(int id, String name, List<Module> modules) {
        this.id = id;
        this.name = name;
        this.modules = modules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", modules=" + modules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id == program.id &&
                Objects.equals(name, program.name) &&
                Objects.equals(modules, program.modules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, modules);
    }
}

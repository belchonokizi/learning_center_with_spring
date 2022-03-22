package com.ilzirabalobanova.epam.learning_center.entity;

import java.util.Objects;

public class Mark {
    private int id;
    private Module module;
    private int value;

    public Mark() {
    }

    public Mark(Module module, int value) {
        this.module = module;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", module=" + module +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return id == mark.id &&
                value == mark.value &&
                Objects.equals(module, mark.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, module, value);
    }
}

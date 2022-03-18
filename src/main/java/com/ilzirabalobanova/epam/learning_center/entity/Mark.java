package com.ilzirabalobanova.epam.learning_center.entity;

import lombok.Data;

@Data
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
}

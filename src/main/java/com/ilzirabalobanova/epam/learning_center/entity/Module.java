package com.ilzirabalobanova.epam.learning_center.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Module {
    private int id;
    private String name;
    private long durationInHours;

    public Module() {
    }

    public Module(int id, int programId, String name, long durationInHours) {
        this.id = id;
        this.name = name;
        this.durationInHours = durationInHours;
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

    public long getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(long durationInHours) {
        this.durationInHours = durationInHours;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", durationInHours=" + durationInHours +
                '}';
    }
}

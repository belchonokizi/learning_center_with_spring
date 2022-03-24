package com.ilzirabalobanova.epam.learning_center.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class Module {
    private int id;
    private int programId;
    private String name;
    private long durationInHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
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
                ", programId=" + programId +
                ", name='" + name + '\'' +
                ", durationInHours=" + durationInHours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return id == module.id &&
                programId == module.programId &&
                durationInHours == module.durationInHours &&
                Objects.equals(name, module.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, programId, name, durationInHours);
    }
}

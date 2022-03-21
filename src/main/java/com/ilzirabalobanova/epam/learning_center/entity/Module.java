package com.ilzirabalobanova.epam.learning_center.entity;

public class Module {
    private int id;
    private int programId;
    private String name;
    private long durationInHours;

    public Module() {
    }

    public Module(int programId, String name, long durationInHours) {
        this.programId = programId;
        this.name = name;
        this.durationInHours = durationInHours;
    }

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
}

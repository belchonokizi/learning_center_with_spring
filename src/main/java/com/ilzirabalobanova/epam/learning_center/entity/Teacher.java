package com.ilzirabalobanova.epam.learning_center.entity;

import java.util.List;

public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String workLevel;
    private List<String> programNames;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String workLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workLevel = workLevel;
    }

    public Teacher(String firstName, String lastName, String workLevel, List<String> programName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workLevel = workLevel;
        this.programNames = programName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkLevel() {
        return workLevel;
    }

    public void setWorkLevel(String workLevel) {
        this.workLevel = workLevel;
    }

    public List<String> getProgramNames() {
        return programNames;
    }

    public void setProgramNames(List<String> programNames) {
        this.programNames = programNames;
    }

    public void addProgramName(String programName) {
        programNames.add(programName);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workLevel='" + workLevel + '\'' +
                ", programNames=" + programNames +
                '}';
    }
}

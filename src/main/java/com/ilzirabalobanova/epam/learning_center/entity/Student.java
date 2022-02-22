package com.ilzirabalobanova.epam.learning_center.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilzirabalobanova.epam.learning_center.annotation.InjectRandomMark;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class Student {
    private static Integer currentId = 68;
    private static Integer generateId() {
        currentId += 1;
        return currentId;
    }

    private int id;
    private String firstName;
    private String lastName;
    private int programId;
    private Map<String, Integer> marksMap;

    public Student() {
    }

    @Autowired
    @JsonCreator
    public Student(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName, @JsonProperty("programId") int programId,
                   @JsonProperty("marksMap") Map<String, Integer> marksMap) {
        this.id = generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.programId = programId;
        this.marksMap = marksMap;
    }

    public Student(int id, String firstName, String lastName, int programId, Map<String, Integer> marksMap) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.programId = programId;
        this.marksMap = marksMap;
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

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public Map<String, Integer> getMarksMap() {
        return marksMap;
    }

    @InjectRandomMark()
    public void setMarksMap(Map<String, Integer> marksMap) {
        this.marksMap = marksMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", programId=" + programId +
                ", marksMap=" + marksMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                programId == student.programId &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(marksMap, student.marksMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, programId, marksMap);
    }
}


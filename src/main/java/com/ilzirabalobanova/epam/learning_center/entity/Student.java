package com.ilzirabalobanova.epam.learning_center.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String phone_number;
    private String email;
    private LocalDate startDay;
    private boolean isFinishedProgram;
    private Program program;
    private List<Mark> marksList;

    public Student() {
    }

    @JsonCreator
    public Student(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName, @JsonProperty("programId") int programId,
                   @JsonProperty("marksMap") Map<String, Integer> marksMap) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public boolean isFinishedProgram() {
        return isFinishedProgram;
    }

    public void setFinishedProgram(boolean finishedProgram) {
        isFinishedProgram = finishedProgram;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<Mark> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Mark> marksList) {
        this.marksList = marksList;
    }

    public void addMark(Mark mark) {
        marksList.add(mark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", startDay=" + startDay +
                ", isFinishedProgram=" + isFinishedProgram +
                ", program=" + program +
                ", marksList=" + marksList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                isFinishedProgram == student.isFinishedProgram &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(phone_number, student.phone_number) &&
                Objects.equals(email, student.email) &&
                Objects.equals(startDay, student.startDay) &&
                Objects.equals(program, student.program) &&
                Objects.equals(marksList, student.marksList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone_number, email, startDay, isFinishedProgram, program, marksList);
    }
}


package com.ilzirabalobanova.epam.learning_center.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate startDay;
    private boolean isFinishedProgram;
    private Program program;
    private List<Mark> marksList;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String phoneNumber, String email, LocalDate startDay, boolean isFinishedProgram, Program program, List<Mark> marksList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startDay = startDay;
        this.isFinishedProgram = isFinishedProgram;
        this.program = program;
        this.marksList = marksList;
    }

    public Student(String firstName, String lastName, String phoneNumber, String email, LocalDate startDay, boolean isFinishedProgram, Program program, List<Mark> marksList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startDay = startDay;
        this.isFinishedProgram = isFinishedProgram;
        this.program = program;
        this.marksList = marksList;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
                ", phone_number='" + phoneNumber + '\'' +
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
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(email, student.email) &&
                Objects.equals(startDay, student.startDay) &&
                Objects.equals(program, student.program) &&
                Objects.equals(marksList, student.marksList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email, startDay, isFinishedProgram, program, marksList);
    }
}


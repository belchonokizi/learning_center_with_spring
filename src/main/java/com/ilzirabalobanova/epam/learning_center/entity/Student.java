package com.ilzirabalobanova.epam.learning_center.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "is_finished_program")
    private boolean isFinishedProgram;

    @Column(name = "program_id")
    private int programId;

    public Student(String firstName, String lastName, String phoneNumber, String email, LocalDate startDay, boolean isFinishedProgram, int programId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startDate = startDay;
        this.isFinishedProgram = isFinishedProgram;
        this.programId = programId;
    }
}


package com.ilzirabalobanova.epam.learning_center.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "marks")
@NoArgsConstructor
@AllArgsConstructor
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "module_id")
    private int moduleId;

    @Column(name = "mark_value")
    private int markValue;

    public Mark(int studentId, int moduleId, int markValue) {
        this.studentId = studentId;
        this.moduleId = moduleId;
        this.markValue = markValue;
    }
}

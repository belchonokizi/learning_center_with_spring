package com.ilzirabalobanova.epam.learning_center.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "modules")
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "program_id")
    private Integer programId;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Long durationInHours;
    public Module(Integer id) {
        this.id = id;
    }
}

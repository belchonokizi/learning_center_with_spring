package com.ilzirabalobanova.epam.learning_center.util;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import java.util.Comparator;

public class Comparators {

    private final Comparator<Student> sortById = Comparator.comparingInt(Student::getId);

    private final Comparator<Student> sortByLastName = Comparator.comparing(Student::getLastName);

    public Comparator<Student> getSortById() {
        return sortById;
    }

    public Comparator<Student> getSortByLastName() {
        return sortByLastName;
    }

}

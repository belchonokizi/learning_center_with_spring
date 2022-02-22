package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import java.util.List;

public interface IProgramService {
    Program findProgramById(int id);

    List<Program> getAllPrograms();

    double getAvgGrade(Student student);
}

package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import java.util.List;

public interface IProgramService {
    Program findProgramById(int id, String path);

    List<Program> getAllPrograms(String path);

    double getAvgGrade(Student student);

    boolean addProgram(Program program, String path);

    boolean deleteProgram(int id, String path);
}

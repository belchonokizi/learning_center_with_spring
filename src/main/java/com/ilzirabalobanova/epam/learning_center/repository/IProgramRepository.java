package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Program;

import java.util.List;

public interface IProgramRepository {

    List<Program> getAllPrograms();

    boolean addProgram(Program program);

    boolean deleteProgram(int id);

    Program findProgramById(int id);
}

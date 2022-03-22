package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Program;

import java.util.List;

public interface IProgramRepository {

    List<Program> getAllPrograms(String path);

    boolean addProgram(Program program, String path);

    boolean deleteProgram(int id, String path);

    Program findProgramById(int id, String path);
}

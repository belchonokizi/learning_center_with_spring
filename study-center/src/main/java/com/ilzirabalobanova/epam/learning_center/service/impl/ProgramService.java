package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProgramService implements IProgramService {
    private final IProgramRepository programRepository;

    @Override
    public Program findProgramById(int id) {
        return programRepository.findProgramById(id);
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.getAllPrograms();
    }

    @Override
    public double getAvgGrade(Student student) {
        return 0;
    }

    @Override
    public boolean addProgram(Program program) {
        programRepository.addProgram(program);
        return true;
    }

    @Override
    public void deleteProgram(int id) {
        programRepository.deleteProgram(id);
    }
}


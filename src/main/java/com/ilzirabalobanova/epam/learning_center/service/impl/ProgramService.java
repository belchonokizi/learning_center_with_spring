package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramService implements IProgramService {
    private final IProgramRepository programRepository;

    @Autowired
    public ProgramService(IProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

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
//        List<Mark> marksList = student.getMarksList();
        List<Mark> marksList = new ArrayList<>();
        double sum = 0;
        for (Mark mark : marksList) {
            sum += mark.getMarkValue();
        }
        return sum / marksList.size();
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


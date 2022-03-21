package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return getAllPrograms().stream().filter(pr -> pr.getId() == id).findFirst()
                .orElseThrow(() -> new NullPointerException("Программа не найдена"));
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.getAllPrograms();
    }


    @Override
    public double getAvgGrade(Student student) {
        List<Mark> marksList = student.getMarksList();
        double sum = 0;
        for (Mark mark : marksList) {
            sum += mark.getValue();
        }
        return sum / marksList.size();
    }

    @Override
    public boolean addProgram(Program program) {
        return programRepository.addProgram(program);
    }

    @Override
    public boolean deleteProgram(int id) {
        return programRepository.deleteProgram(id);
    }
}


package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProgramService implements IProgramService {
    private IProgramRepository programRepository;

    @Autowired
    @Lazy
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
        Map<String, Integer> marksMap = student.getMarksMap();
        return marksMap.values().stream().mapToDouble(d -> d).sum() / marksMap.size();
    }
}


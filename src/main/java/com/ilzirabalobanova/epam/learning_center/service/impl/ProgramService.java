package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramService implements IProgramService {
    private final Logger logger = LoggerFactory.logger(ProgramService.class);
    private final IProgramRepository programRepository;

    @Autowired
    public ProgramService(IProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program findProgramById(int id) {
        Program resultProgram = null;
        Optional<Program> program = programRepository.findById(id);
        if (program.isPresent()) {
            resultProgram = program.get();
        } else {
            logger.error("Программа не найдена");
        }
        return resultProgram;
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }


    @Override
    public double getAvgGrade(Student student) {
//        List<Mark> marksList = student.getMarksList();
        List<Mark> marksList = new ArrayList<>();
        double sum = 0;
        for (Mark mark : marksList) {
            sum += mark.getValue();
        }
        return sum / marksList.size();
    }

    @Override
    public boolean addProgram(Program program) {
       programRepository.save(program);
       return true;
    }

    @Override
    public void deleteProgram(int id) {
        programRepository.deleteById(id);
    }
}


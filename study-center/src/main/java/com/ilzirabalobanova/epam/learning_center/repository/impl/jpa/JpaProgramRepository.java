package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepositoryForJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
public class JpaProgramRepository extends SimpleJpaRepository<Program, Integer> implements IProgramRepositoryForJpa {
    public JpaProgramRepository(Class<Program> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public List<Program> getAllPrograms() {
        return findAll();
    }

    @Override
    @Transactional
    public boolean addProgram(Program program) {
        save(program);
        return true;
    }

    @Override
    @Transactional
    public void deleteProgram(int id) {
        deleteById(id);
    }

    @Override
    public Program findProgramById(int id) {
        Program resultProgram = null;
        Optional<Program> program = findById(id);
        if (program.isPresent()) {
            resultProgram = program.get();
        } else {
            log.error("Программа не найдена");
        }
        return resultProgram;
    }

}

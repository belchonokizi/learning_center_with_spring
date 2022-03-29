package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepositoryForJpa;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaProgramRepository extends SimpleJpaRepository<Program, Integer> implements IProgramRepositoryForJpa {
    private final Logger logger = LoggerFactory.logger(JpaProgramRepository.class);

    public JpaProgramRepository(Class<Program> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public List<Program> getAllPrograms() {
        return findAll();
    }

    @Override
    public boolean addProgram(Program program) {
        save(program);
        return true;
    }

    @Override
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
            logger.error("Программа не найдена");
        }
        return resultProgram;
    }
}

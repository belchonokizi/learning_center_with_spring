package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.parser.YamlParser;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProgramRepository implements IProgramRepository {
    private final YamlParser parser;
    private List<Program> programDatabase;

    public ProgramRepository(YamlParser parser) {
        this.parser = parser;
    }

    @PostConstruct
    public void init() {
        programDatabase = parser.getPrograms(Constants.PATH_YAML_FILE);
    }

    @Override
    public List<Program> getAllPrograms() {
        return programDatabase;
    }

}


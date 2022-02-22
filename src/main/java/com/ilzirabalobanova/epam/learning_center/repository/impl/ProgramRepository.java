package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.parser.YamlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@Repository
public class ProgramRepository implements IProgramRepository {
    private final YamlParser parser;
    private List<Program> programDatabase;

    @Autowired
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

    private String getPath() throws IOException {
        Properties properties = new Properties();
        InputStream is = ProgramRepository.class.getClassLoader().getResourceAsStream("path.properties");
        properties.load(is);
        return properties.getProperty("PATH_YAML_FILE");
    }
}


package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.ProgramDataExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class JDBCProgramRepository implements IProgramRepository {
    private final Logger logger = LoggerFactory.getLogger(JDBCProgramRepository.class);

    private final JdbcTemplate jdbcTemplate;
    private final ProgramDataExtractor extractor;
    private final SqlQueriesReader reader;
    private final GeneratedKeyHolder keyHolder;

    @Autowired
    public JDBCProgramRepository(JdbcTemplate jdbcTemplate, ProgramDataExtractor extractor, SqlQueriesReader reader, GeneratedKeyHolder keyHolder) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
        this.reader = reader;
        this.keyHolder = keyHolder;
    }

    @Override
    public List<Program> getAllPrograms(String path) {
        String query = reader.readSqlQueries(path);
        return jdbcTemplate.query(query, extractor);
    }

    @Override
    public boolean addProgram(Program program, String path) {
        String query = reader.readSqlQueries(path);
        int rowCount = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, new String[]{"id"});
            preparedStatement.setString(1, program.getName());
            return preparedStatement;
        }, keyHolder);
        program.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return rowCount == 1;
    }

    @Override
    public boolean deleteProgram(int id, String path) {
        String query = reader.readSqlQueries(path);
        return jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement;
        }) == 1;
    }

    @Override
    public Program findProgramById(int id, String path) {
        String query = reader.readSqlQueries(path);
        List<Program> programs = jdbcTemplate.query(query, extractor, id);
        Program program = null;
        if (programs.isEmpty()) {
            logger.error("Программа не найден");
        } else {
            program = programs.get(0);
        }
        return program;
    }
}

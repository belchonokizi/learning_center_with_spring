package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.ProgramDataExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCProgramRepository implements IProgramRepository {
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
    public List<Program> getAllPrograms() {
        String query = reader.readSqlQueries(Constants.GET_ALL_PROGRAMS_SQL_QUERY_PATH);
        return jdbcTemplate.query(query, extractor);
    }
}

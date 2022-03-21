package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.repository.IMarkRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCMarkRepository implements IMarkRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SqlQueriesReader reader;

    public JDBCMarkRepository(JdbcTemplate jdbcTemplate, SqlQueriesReader reader) {
        this.jdbcTemplate = jdbcTemplate;
        this.reader = reader;
    }

    @Override
    public boolean updateMark(int studentId, int moduleId, int value) {
        String query = reader.readSqlQueries(Constants.UPDATE_MARK_SQL_QUERY_PATH);
        int rowCount = jdbcTemplate.update(query, value, studentId, moduleId);
        return rowCount == 1;
    }
}

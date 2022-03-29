package com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.repository.IMarkRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.MarkDataExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCMarkRepository implements IMarkRepository {
    private JdbcTemplate jdbcTemplate;
    private SqlQueriesReader reader;
    private MarkDataExtractor extractor;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setReader(SqlQueriesReader reader) {
        this.reader = reader;
    }

    @Autowired
    public void setExtractor(MarkDataExtractor extractor) {
        this.extractor = extractor;
    }

    @Override
    public List<Mark> findStudentMarks(int studentId) {
        String query = reader.readSqlQueries(Constants.FIND_MARKS_BY_STUDENT_ID);
        return jdbcTemplate.query(query, extractor, studentId);
    }

    @Override
    public boolean updateMark(int studentId, int moduleId, int value) {
        String query = reader.readSqlQueries(Constants.UPDATE_MARK_SQL_QUERY_PATH);
        int rowCount = jdbcTemplate.update(query, value, studentId, moduleId);
        return rowCount == 1;
    }
}

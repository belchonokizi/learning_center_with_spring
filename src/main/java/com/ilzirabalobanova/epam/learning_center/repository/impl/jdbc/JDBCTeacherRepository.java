package com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.ITeacherRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.TeacherDataExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

public class JDBCTeacherRepository implements ITeacherRepository {
    private final Logger logger = LoggerFactory.getLogger(JDBCTeacherRepository.class);

    private JdbcTemplate jdbcTemplate;
    private TeacherDataExtractor extractor;
    private SqlQueriesReader reader;
    private GeneratedKeyHolder keyHolder;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setExtractor(TeacherDataExtractor extractor) {
        this.extractor = extractor;
    }

    @Autowired
    public void setReader(SqlQueriesReader reader) {
        this.reader = reader;
    }

    @Autowired
    public void setKeyHolder(GeneratedKeyHolder keyHolder) {
        this.keyHolder = keyHolder;
    }

    public List<Teacher> getAllTeachers() {
        String query = reader.readSqlQueries(Constants.GET_ALL_TEACHERS_SQL_QUERY_PATH);
        return jdbcTemplate.query(query, extractor);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        String query = reader.readSqlQueries(Constants.ADD_TEACHER_SQL_QUERY_PATH);
        int rowCount = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, new String[]{"id"});
            preparedStatement.setString(1, teacher.getFirstName());
            preparedStatement.setString(2, teacher.getLastName());
            preparedStatement.setString(3, teacher.getWorkLevel());
            return preparedStatement;
        }, keyHolder);
        teacher.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return rowCount == 1;
    }

    @Override
    public void deleteTeacher(int id) {
        String query = reader.readSqlQueries(Constants.DELETE_TEACHER_SQL_QUERY_PATH);
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement;
        });
    }

    @Override
    public Teacher findTeacherById(int id) {
        String query = reader.readSqlQueries(Constants.FIND_TEACHER_BY_ID_SQL_QUERY_PATH);
        List<Teacher> teachers = jdbcTemplate.query(query, extractor, id);
        Teacher teacher = null;
        if (teachers.isEmpty()) {
            logger.error("Учитель не найден");
        } else {
            teacher = teachers.get(0);
        }
        return teacher;
    }
}

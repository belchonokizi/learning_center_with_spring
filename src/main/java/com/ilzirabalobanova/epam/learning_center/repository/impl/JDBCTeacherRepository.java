package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.ITeacherRepository;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.TeacherDataExtractor;
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
public class JDBCTeacherRepository implements ITeacherRepository {
    private final Logger logger = LoggerFactory.getLogger(JDBCTeacherRepository.class);

    private final JdbcTemplate jdbcTemplate;
    private final TeacherDataExtractor extractor;
    private final SqlQueriesReader reader;
    private final GeneratedKeyHolder keyHolder;

    @Autowired
    public JDBCTeacherRepository(JdbcTemplate jdbcTemplate, TeacherDataExtractor extractor, SqlQueriesReader reader, GeneratedKeyHolder keyHolder) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
        this.reader = reader;
        this.keyHolder = keyHolder;
    }

    @Override
    public List<Teacher> getAllTeachers(String path) {
        String query = reader.readSqlQueries(path);
        return jdbcTemplate.query(query, extractor);
    }

    @Override
    public boolean addTeacher(Teacher teacher, String path) {
        String query = reader.readSqlQueries(path);
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
    public boolean deleteTeacher(int id, String path) {
        String query = reader.readSqlQueries(path);
        return jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement;
        }) == 1;
    }

    @Override
    public Teacher findTeacherById(int id, String path) {
        String query = reader.readSqlQueries(path);
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

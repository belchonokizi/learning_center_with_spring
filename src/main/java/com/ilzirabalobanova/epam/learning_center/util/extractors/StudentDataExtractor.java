package com.ilzirabalobanova.epam.learning_center.util.extractors;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentDataExtractor implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        return null;
    }
}

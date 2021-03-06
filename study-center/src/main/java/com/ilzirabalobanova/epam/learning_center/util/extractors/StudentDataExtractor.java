package com.ilzirabalobanova.epam.learning_center.util.extractors;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDataExtractor implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Student> studentsMap = new HashMap<>();
        while (rs.next()) {
            int studentId = rs.getInt("student_id");
            Student student = studentsMap.get(studentId);
            if (student == null) {
                student = new Student();
                student.setId(studentId);
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setPhoneNumber(rs.getString("phone_number"));
                student.setEmail(rs.getString("email"));
                student.setPrograms(List.of(new Program(rs.getInt("program_id"))));
            }
            studentsMap.put(studentId, student);
        }
        return new ArrayList<>(studentsMap.values());
    }
}

package com.ilzirabalobanova.epam.learning_center.util.extractors;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
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
public class TeacherDataExtractor implements ResultSetExtractor<List<Teacher>> {
    @Override
    public List<Teacher> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Teacher> teacherMap = new HashMap<>();
        Map<Integer, String> programNames = new HashMap<>();
        while (rs.next()) {
            int teacherId = rs.getInt("teacher_id");
            Teacher teacher = teacherMap.get(teacherId);
            if (teacher == null) {
                teacher = new Teacher();
                teacher.setId(teacherId);
                teacher.setFirstName(rs.getString("teacher_first_name"));
                teacher.setLastName(rs.getString("teacher_last_name"));
                teacher.setWorkLevel(rs.getString("teacher_level"));
                teacher.setProgramNames(new ArrayList<>());
                teacherMap.put(teacherId, teacher);
            }
            int pairId = rs.getInt("pair_id");
            String programName = programNames.get(pairId);
            if (programName == null) {
                programName = rs.getString("program_name");
                teacher.addProgramName(programName);
            }
        }
        return new ArrayList<>(teacherMap.values());
    }
}


package com.ilzirabalobanova.epam.learning_center.util.extractors;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDataExtractor implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Student> studentsMap = new HashMap<>();
        Map<Integer, Program> programMap = new HashMap<>();
        Map<Integer, Module> moduleMap = new HashMap<>();
        Map<Integer, Mark> markMap = new HashMap<>();
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
                student.setStartDay(LocalDate.parse(rs.getString("start_date")));
                student.setFinishedProgram((rs.getInt("is_finished_program") == 1));
                student.setMarksList(new ArrayList<>());
            }
            int programId = rs.getInt("program_id");
            Program program = programMap.get(programId);
            if (program == null) {
                program = new Program();
                program.setId(rs.getInt("program_id"));
                program.setName(rs.getString("program_name"));
                program.setModules(new ArrayList<>());
                programMap.put(programId, program);
            }

            int moduleId = rs.getInt("module_id");
            Module module = moduleMap.get(moduleId);
            if (module == null) {
                module = new Module();
                module.setId(moduleId);
                module.setProgramId(programId);
                module.setName(rs.getString("module_name"));
                module.setDurationInHours(rs.getLong("module_duration"));
                moduleMap.put(moduleId, module);
                program.addModule(module);
            }

            int markId = rs.getInt("mark_id");
            Mark mark = markMap.get(markId);
            if (mark == null) {
                mark = new Mark();
                mark.setId(markId);
                mark.setModule(module);
                mark.setValue(rs.getInt("mark_value"));
                markMap.put(markId, mark);
                student.addMark(mark);
            }
            student.setProgram(program);
            studentsMap.put(studentId, student);
        }
        return new ArrayList<>(studentsMap.values());
    }
}

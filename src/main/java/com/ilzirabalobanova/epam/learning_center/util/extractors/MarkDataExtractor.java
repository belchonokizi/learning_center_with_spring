package com.ilzirabalobanova.epam.learning_center.util.extractors;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Module;
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
public class MarkDataExtractor implements ResultSetExtractor<List<Mark>> {
    @Override
    public List<Mark> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Mark> markMap = new HashMap<>();
        while (rs.next()) {
            int markId = rs.getInt("id");
            Mark mark = markMap.get(markId);
            if (mark == null) {
                mark = new Mark();
                mark.setId(markId);
                mark.setStudentId(rs.getInt("student_id"));
                mark.setModule(new Module(rs.getInt("module_id")));
                mark.setMarkValue(rs.getInt("mark_value"));
                markMap.put(markId, mark);
            }
        }
        return new ArrayList<>(markMap.values());
    }
}

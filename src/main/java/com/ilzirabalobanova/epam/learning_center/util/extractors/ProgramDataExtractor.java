package com.ilzirabalobanova.epam.learning_center.util.extractors;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
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
public class ProgramDataExtractor implements ResultSetExtractor<List<Program>> {
    @Override
    public List<Program> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Program> programMap = new HashMap<>();
        Map<Integer, Module> moduleMap = new HashMap<>();
        while (rs.next()) {
            int programId = rs.getInt("program_id");
            Program program = programMap.get(programId);
            if (program == null) {
                program = new Program();
                program.setId(programId);
                program.setName(rs.getString("program_name"));
                program.setModules(new ArrayList<>());
                programMap.put(programId, program);
            }

            int moduleId = rs.getInt("module_id");
            Module module = moduleMap.get(moduleId);
            if (module == null) {
                module = new Module();
                module.setId(moduleId);
                module.setName(rs.getString("module_name"));
                module.setDurationInHours(rs.getLong("module_duration"));
                moduleMap.put(moduleId, module);
                program.addModule(module);
            }
        }
        return new ArrayList<>(programMap.values());
    }
}

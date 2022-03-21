package com.ilzirabalobanova.epam.learning_center.util.extractors;

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
public class ModuleDataExtractor implements ResultSetExtractor<List<Module>> {
    @Override
    public List<Module> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Module> moduleMap = new HashMap<>();
        while (rs.next()) {
            int moduleId = rs.getInt("module_id");
            Module module = moduleMap.get(moduleId);
            if (module == null) {
                module = new Module();
                module.setId(moduleId);
                module.setName(rs.getString("module_name"));
                module.setDurationInHours(rs.getLong("module_duration"));
                moduleMap.put(moduleId, module);
            }
        }
        return new ArrayList<>(moduleMap.values());
    }
}

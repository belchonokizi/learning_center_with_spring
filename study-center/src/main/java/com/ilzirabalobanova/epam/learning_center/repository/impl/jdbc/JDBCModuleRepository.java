package com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.repository.IModuleRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.ModuleDataExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

public class JDBCModuleRepository implements IModuleRepository {
    private JdbcTemplate jdbcTemplate;
    private ModuleDataExtractor extractor;
    private SqlQueriesReader reader;
    private GeneratedKeyHolder keyHolder;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setExtractor(ModuleDataExtractor extractor) {
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

    @Override
    public List<Module> findAllModulesByProgramId(int programId) {
        String query = reader.readSqlQueries(Constants.FIND_ALL_MODULES_BY_PROGRAM_ID_SQL_QUERY_PATH);
        return jdbcTemplate.query(query, extractor, programId);
    }

    @Override
    public boolean addModule(Module module) {
        String query = reader.readSqlQueries(Constants.ADD_MODULE_SQL_QUERY_PATH);
        int rowCount = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, new String[]{"id"});
            preparedStatement.setInt(1, module.getProgramId());
            preparedStatement.setString(2, module.getName());
            preparedStatement.setLong(3, module.getDurationInHours());
            return preparedStatement;
        }, keyHolder);
        module.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return rowCount == 1;
    }

    @Override
    public boolean deleteModule(int moduleId) {
        String query = reader.readSqlQueries(Constants.DELETE_MODULE_SQL_QUERY_PATH);
        return jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, moduleId);
            return preparedStatement;
        }) == 1;
    }

    @Override
    public Module findModuleById(int moduleId) {
        return null;
    }
}

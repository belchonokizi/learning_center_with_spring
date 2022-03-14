package com.ilzirabalobanova.epam.learning_center.util.parser;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class YamlParser {
    private static final Logger logger = LoggerFactory.getLogger(YamlParser.class);

    public List<Program> getPrograms(String path) {
        List<Program> programList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(path)) {
            Yaml yaml = new Yaml(new Constructor(Program.class));
            for (Object object : yaml.loadAll(inputStream)) {
                Program program = (Program) object;
                programList.add(program);
            }
        } catch (FileNotFoundException e) {
            logger.error("Файл properties.yaml не найден");
        } catch (IOException e) {
            logger.error("Ошибка чтения файла properties.yaml");
        }
        return programList;
    }
}


package com.ilzirabalobanova.epam.learning_center.util;

import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {
    private static final Logger logger = LoggerFactory.getLogger(Validator.class);

    private final IProgramService programService;

    @Autowired
    public Validator(IProgramService programService) {
        this.programService = programService;
    }

    public boolean isNameNonValid(String string) {
        if (string.isBlank() || string.matches(Constants.REGEX_NON_DIGITS_AND_PUNCT)) {
            logger.error("Некорректное значение имени/фамилии");
            return true;
        }
        return false;
    }

    public boolean isIntValid(int id) {
        boolean isPresent = programService.getAllPrograms().stream().anyMatch(p -> p.getId() == id);
        if (!isPresent) {
            logger.error("Некорректный номер программы");
        }
        return isPresent;
    }
}

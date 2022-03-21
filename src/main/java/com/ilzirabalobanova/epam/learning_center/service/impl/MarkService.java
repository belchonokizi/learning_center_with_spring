package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.repository.IMarkRepository;
import com.ilzirabalobanova.epam.learning_center.service.IMarkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkService implements IMarkService {
    private final Logger logger = LoggerFactory.getLogger(MarkService.class);
    private final IMarkRepository markRepository;

    @Autowired
    public MarkService(IMarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public boolean updateMark(int studentId, int moduleId, int value) {
        boolean result = markRepository.updateMark(studentId, moduleId, value);
        if (!result) {
            logger.error("Ошибка в добавлении оценки");
        }
        return result;
    }
}

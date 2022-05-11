package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.repository.IMarkRepository;
import com.ilzirabalobanova.epam.learning_center.service.IMarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarkService implements IMarkService {
    private final IMarkRepository markRepository;

    @Override
    public void putNewMark(int studentId, int moduleId, int value) {
        markRepository.putNewMark(studentId, moduleId, value);
    }
    @Override
    public boolean updateMark(int studentId, int moduleId, int value) {
        boolean result = markRepository.updateMark(studentId, moduleId, value);
        if (!result) {
            log.error("Ошибка в добавлении оценки");
        }
        return result;
    }
    @Override
    public List<Mark> findStudentMarks(int studentId) {
        return markRepository.findStudentMarks(studentId);
    }

}

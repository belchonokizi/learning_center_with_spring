package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;

import java.util.List;

public interface IMarkService {
    boolean updateMark(int studentId, int moduleId, int value);
    void putNewMark(int studentId, int moduleId, int value);
    List<Mark> findStudentMarks(int studentId);

}


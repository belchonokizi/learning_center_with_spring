package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;

import java.util.List;

public interface IMarkRepository {
    List<Mark> findStudentMarks(int studentId);
    boolean updateMark(int studentId, int moduleId, int value);
    void putNewMark(int studentId, int moduleId, int value);
}

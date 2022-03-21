package com.ilzirabalobanova.epam.learning_center.repository;

public interface IMarkRepository {
    boolean updateMark(int studentId, int moduleId, int value);
}

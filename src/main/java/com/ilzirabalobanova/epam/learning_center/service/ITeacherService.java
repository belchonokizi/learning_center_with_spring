package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> getAllTeachers();

    boolean addTeacher(Teacher teacher);

    void deleteTeacher(int id);

    Teacher findTeacherById(int id);
}

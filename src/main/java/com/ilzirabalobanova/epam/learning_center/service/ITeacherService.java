package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> getAllTeachers();

    boolean addTeacher(Teacher teacher, int programId);

    boolean deleteTeacher(int id);

    Teacher findTeacherById(int id);
}

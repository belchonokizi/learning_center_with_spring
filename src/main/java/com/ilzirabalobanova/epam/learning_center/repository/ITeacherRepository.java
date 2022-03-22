package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;

import java.util.List;

public interface ITeacherRepository {
    List<Teacher> getAllTeachers(String path);

    boolean addTeacher(Teacher teacher, String path);

    boolean deleteTeacher(int id, String path);

    Teacher findTeacherById(int id, String path);
}

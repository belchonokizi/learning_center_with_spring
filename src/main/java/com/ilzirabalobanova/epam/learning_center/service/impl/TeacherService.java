package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.ITeacherRepository;
import com.ilzirabalobanova.epam.learning_center.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {
    private final ITeacherRepository teacherRepository;

    @Autowired
    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers(String path) {
        return teacherRepository.getAllTeachers(path);
    }

    @Override
    public boolean addTeacher(Teacher teacher, String path) {
        return teacherRepository.addTeacher(teacher, path);
    }

    @Override
    public boolean deleteTeacher(int id, String path) {
        return teacherRepository.deleteTeacher(id, path);
    }

    @Override
    public Teacher findTeacherById(int id, String path) {
        return teacherRepository.findTeacherById(id, path);
    }
}

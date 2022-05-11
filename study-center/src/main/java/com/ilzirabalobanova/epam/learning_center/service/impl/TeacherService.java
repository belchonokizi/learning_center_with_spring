package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.ITeacherRepository;
import com.ilzirabalobanova.epam.learning_center.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService implements ITeacherService {
    private final ITeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteTeacher(id);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return teacherRepository.findTeacherById(id);
    }
}

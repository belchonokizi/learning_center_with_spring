package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.ITeacherRepository;
import com.ilzirabalobanova.epam.learning_center.service.ITeacherService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    private final Logger logger = LoggerFactory.logger(TeacherService.class);

    private final ITeacherRepository teacherRepository;

    @Autowired
    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Sort sort = Sort.by("lastName").ascending();
        return (List<Teacher>) teacherRepository.findAll(sort);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return true;
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.delete(findTeacherById(id));
    }

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacher = null;
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            teacher = optionalTeacher.get();
        } else {
            logger.error("Учитель не найден");
        }
        return teacher;
    }
}

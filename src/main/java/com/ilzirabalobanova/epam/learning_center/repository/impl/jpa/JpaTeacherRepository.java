package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.ITeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
public class JpaTeacherRepository extends SimpleJpaRepository<Teacher, Integer> implements ITeacherRepository {

    public JpaTeacherRepository(Class<Teacher> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Sort sort = Sort.by("lastName").ascending();
        return findAll(sort);
    }

    @Override
    @Transactional
    public boolean addTeacher(Teacher teacher) {
        Teacher result = save(teacher);
        return result.equals(teacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(int id) {
        deleteById(id);
    }

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacher = null;
        Optional<Teacher> optionalTeacher = findById(id);
        if (optionalTeacher.isPresent()) {
            teacher = optionalTeacher.get();
        } else {
            log.error("Учитель не найден");
        }
        return teacher;
    }
}

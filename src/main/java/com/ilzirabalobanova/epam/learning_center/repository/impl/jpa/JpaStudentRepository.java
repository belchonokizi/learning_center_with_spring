package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaStudentRepository implements IStudentRepository {

    private final EntityManager entityManager;

    @Autowired
    public JpaStudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = entityManager.unwrap(Session.class);
        Query<Student> query = session.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public boolean addStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }

    @Override
    public Student findStudentById(int id) {
        return null;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        return null;
    }
}

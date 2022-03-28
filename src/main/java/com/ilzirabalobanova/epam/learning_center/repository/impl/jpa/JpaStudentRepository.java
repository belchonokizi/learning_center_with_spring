package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        Session session = entityManager.unwrap(Session.class);
        return session.save(student) != null;
    }

    @Transactional
    @Override
    public boolean deleteStudent(int id) {
        return entityManager.createQuery("delete from Student " +
                "where id = :id").setParameter("id", id).executeUpdate() == 1;
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    @Override
    public Student updateStudent(int studentId, Student student) {
        return (Student) entityManager.unwrap(Session.class).merge(student);
    }
}

package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.repository.IMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class JpaMarkRepository implements IMarkRepository {
    private final EntityManager entityManager;

    @Autowired
    public JpaMarkRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public boolean updateMark(int studentId, int moduleId, int value) {
        Query query = entityManager.createNativeQuery
                ("UPDATE marks SET value = ? WHERE student_id = ? and module_id = ?");
        query.setParameter(1, value);
        query.setParameter(2, studentId);
        query.setParameter(3, moduleId);
        return query.executeUpdate() == 1;
    }
}

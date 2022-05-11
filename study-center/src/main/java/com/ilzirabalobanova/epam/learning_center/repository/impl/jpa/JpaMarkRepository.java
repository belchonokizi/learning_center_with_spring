package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.repository.IMarkRepository;
import com.ilzirabalobanova.epam.learning_center.service.IModuleService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMarkRepository implements IMarkRepository {
    private EntityManager entityManager;
    private IModuleService moduleService;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    public void setModuleService(IModuleService moduleService) {
        this.moduleService = moduleService;
    }

    public List<Mark> findStudentMarks(int studentId) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Mark> criteriaQuery = criteriaBuilder.createQuery(Mark.class);
        Root<Mark> root = criteriaQuery.from(Mark.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("studentId"), studentId));

        org.hibernate.query.Query<Mark> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void putNewMark(int studentId, int moduleId, int value) {
        Module module = moduleService.findModuleById(moduleId);
        Mark mark = new Mark(studentId, module, value);
        entityManager.unwrap(Session.class).save(mark);
    }

    @Transactional
    @Override
    public boolean updateMark(int studentId, int moduleId, int value) {
        Query query = entityManager.createNativeQuery
                ("UPDATE marks SET mark_value = ? WHERE student_id = ? and module_id = ?");
        query.setParameter(1, value);
        query.setParameter(2, studentId);
        query.setParameter(3, moduleId);
        return query.executeUpdate() == 1;
    }
}

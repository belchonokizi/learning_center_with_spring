package com.ilzirabalobanova.epam.learning_center.repository.impl.jpa;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.repository.IModuleRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaModuleRepository implements IModuleRepository {
    private EntityManager entityManager;
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Module> findAllModulesByProgramId(int programId) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Module> criteriaQuery = criteriaBuilder.createQuery(Module.class);
        Root<Module> root = criteriaQuery.from(Module.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("programId"), programId));

        Query<Module> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public boolean addModule(Module module) {
        Session session = entityManager.unwrap(Session.class);
        return session.save(module) != null;
    }

    @Transactional
    @Override
    public boolean deleteModule(int moduleId) {
        return entityManager.createQuery("delete from Module " +
                "where id = :id").setParameter("id", moduleId).executeUpdate() == 1;
    }

    @Override
    public Module findModuleById(int moduleId) {
        return entityManager.find(Module.class, moduleId);
    }
}

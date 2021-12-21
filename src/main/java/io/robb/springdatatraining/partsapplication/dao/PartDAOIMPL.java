package io.robb.springdatatraining.partsapplication.dao;

import io.robb.springdatatraining.partsapplication.entities.Part;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class PartDAOIMPL implements PartDAO {

    private final EntityManager entityManager;

    @Autowired
    public PartDAOIMPL (EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Part> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Part> myQuery= currentSession.createQuery("from Part");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Part.class,id);
    }

    @Override
    @Transactional
    public void SaveOrUpdate(Part part) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(part);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Part myPart = currentSession.get(Part.class, id);
        currentSession.delete(myPart);
    }
}

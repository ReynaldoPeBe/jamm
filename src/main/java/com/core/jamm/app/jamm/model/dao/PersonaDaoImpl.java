package com.core.jamm.app.jamm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.core.jamm.app.jamm.entity.Persona;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * PersonaDaoImpl
 */
@Repository
public class PersonaDaoImpl implements IPersonaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Persona> findAll() {
        return em.createQuery("from Persona").getResultList();
    }
    
}
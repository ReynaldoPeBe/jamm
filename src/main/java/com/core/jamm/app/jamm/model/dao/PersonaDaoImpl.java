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

    @Override
    @Transactional
    public void save(Persona persona) {
        if (persona.getId() != null && persona.getId() > 0) {
            em.merge(persona);
        }else{
            em.persist(persona);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findOne(Long id) {
        return em.find(Persona.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Persona persona=findOne(id);
        em.remove(persona);
    }

}
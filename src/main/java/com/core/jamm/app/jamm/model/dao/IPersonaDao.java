package com.core.jamm.app.jamm.model.dao;

import java.util.List;

import com.core.jamm.app.jamm.entity.Persona;

/**
 * IPersonaDao
 * 
 */
public interface IPersonaDao {

    public List<Persona> findAll();

    public void save(Persona persona);
    
    public Persona findOne(Long id);

}
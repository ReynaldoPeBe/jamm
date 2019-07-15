package com.core.jamm.app.jamm.service;

import java.util.List;

import com.core.jamm.app.jamm.entity.Persona;

/**
 * IPersonaService
 */
public interface IPersonaService {

    public List<Persona> findAll();

    public void save(Persona persona);
    
    public Persona findOne(Long id);

    public void delete(Long id);

}
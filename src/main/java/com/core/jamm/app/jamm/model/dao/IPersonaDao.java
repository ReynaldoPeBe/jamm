package com.core.jamm.app.jamm.model.dao;



import com.core.jamm.app.jamm.entity.Persona;

import org.springframework.data.repository.CrudRepository;

/**
 * IPersonaDao
 * 
 */
public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
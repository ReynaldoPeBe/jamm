package com.core.jamm.app.jamm.repository;



import com.core.jamm.app.jamm.model.Persona;

import org.springframework.data.repository.CrudRepository;

/**
 * IPersonaDao
 * 
 */
public interface IPersonaRepository extends CrudRepository<Persona, Long> {

}
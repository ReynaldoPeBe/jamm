package com.core.jamm.app.jamm.serviceImpl;

import java.util.List;

import com.core.jamm.app.jamm.model.Persona;
import com.core.jamm.app.jamm.repository.IPersonaRepository;
import com.core.jamm.app.jamm.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PersonaServiceImpl
 */
@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepository personaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findOne (Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personaDao.deleteById(id);
    }
    
}
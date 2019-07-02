package com.core.jamm.app.jamm.controller;

import java.util.List;
import java.util.Map;

import com.core.jamm.app.jamm.model.dao.IPersonaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PersonaController
 */
@Controller
public class PersonaController {

    @Autowired
    private IPersonaDao personaDao;

    @GetMapping(value = "/listarpersonas")
    public String listarpersonas(Map<String, Object> m) {
        m.put("titulo", "Listado de Personas");
        m.put("personas", personaDao.findAll());
        return "/persona/listarpersonas";
    }
}
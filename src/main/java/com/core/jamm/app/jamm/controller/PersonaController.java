package com.core.jamm.app.jamm.controller;

import java.util.Map;

import com.core.jamm.app.jamm.entity.Persona;
import com.core.jamm.app.jamm.model.dao.IPersonaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping(value = "/formulariopersona")
    public String formulariopersona(Model m) {
        Persona persona =new Persona();
        m.addAttribute("persona", persona);
        m.addAttribute("titulo", "Formulario Personas");
        return "/persona/formulariopersona";
    }
}
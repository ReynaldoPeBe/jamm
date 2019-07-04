package com.core.jamm.app.jamm.controller;

import java.util.Map;

import javax.validation.Valid;

import com.core.jamm.app.jamm.entity.Persona;
import com.core.jamm.app.jamm.model.dao.IPersonaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        m.addAttribute("persona", persona); //VARIABLE objetowwww   para el @ModelAttribute("") si tienen el mismo nombre no es necesario
        m.addAttribute("titulo", "Formulario Personas");
        return "/persona/formulariopersona";
    }

    //@Valid y BindingResult siempre juntos
    // @ModelAttribute("persona") aqui esta la variable del objeto    VARIABLE objetowwww 
    @PostMapping (value = "/formulariopersona")
    public String savepersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult result, Model m){
        if(result.hasErrors()){
            m.addAttribute("titulo", "Formulario Personas");
            return "/persona/formulariopersona";
        }
        personaDao.save(persona);
        return "redirect:/listarpersonas";
    }

}
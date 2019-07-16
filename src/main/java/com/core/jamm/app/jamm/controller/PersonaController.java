package com.core.jamm.app.jamm.controller;

import java.util.Map;

import javax.validation.Valid;

import com.core.jamm.app.jamm.entity.Persona;
import com.core.jamm.app.jamm.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * PersonaController
 */
@Controller
// sesion para capturar el id de wilcard para actualizar o eleimnar persona
@SessionAttributes("persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping(value = "/listarpersonas")
    public String listarpersonas(Map<String, Object> m) {
        m.put("titulo", "Listado de Personas");
        m.put("personas", personaService.findAll());
        return "/persona/listarpersonas";
    }

    @GetMapping(value = "/formulariopersona")
    public String formulariopersona(Model m) {
        Persona persona = new Persona();
        m.addAttribute("persona", persona); // VARIABLE objetowwww para el @ModelAttribute("") si tienen el mismo nombre
                                            // no es necesario
        m.addAttribute("titulo", "Formulario Personas");
        return "/persona/formulariopersona";
    }

    // @Valid y BindingResult siempre juntos
    // @ModelAttribute("persona") aqui esta la variable del objeto VARIABLE
    // objetowwww
    @PostMapping(value = "/formulariopersona")
    public String savepersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult result, Model m,
            SessionStatus status) {
        if (result.hasErrors()) {
            m.addAttribute("titulo", "Formulario Personas");
            return "/persona/formulariopersona";
        }
        personaService.save(persona);
        status.setComplete();
        return "redirect:/listarpersonas";
    }

    // value=id tiene el el mismo nombre de variable del {id}
    @GetMapping(value = "/formulariopersona/{id}")
    public String editarparsona(@PathVariable(value = "id") Long id, Model m) {
        Persona persona = null;
        if (id > 0) {
            persona = personaService.findOne(id);
        } else {
            return "redirect:/listarpersonas";
        }
        m.addAttribute("persona", persona);
        m.addAttribute("titulo", "Editar persona");
        return "/persona/formulariopersona";
    }

    @GetMapping(value = "/  /{id}")
    public String deletepersona(Model m, @PathVariable(value = "id") Long id) {
        if (id > 0) {
            personaService.delete(id);
        }
        return "redirect:/listarpersonas";
    }

}
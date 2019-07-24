package com.core.jamm.app.jamm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 */
@Controller
public class IndexController {

    @GetMapping({ "/", "/index", "/home" })
    public String index(Model m) {
        m.addAttribute("titulo", "Bienvenido, estas en JAMM - JC");
        return "index";
    }

    @GetMapping(value = "/inicio")
    public String inicio (Model m){
        m.addAttribute("titulo", "Inicio JAMM-JC");
        return "/inicio";
    }

}
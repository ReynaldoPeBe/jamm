package com.core.jamm.app.jamm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PredioController
 */
@Controller
public class PredioController {

    @GetMapping(value = "/datapredios")
    public String datapredios(Model m) {
        System.out.println("Entrando a JAVITA");
        m.addAttribute("v_ajax","Pruebas Ajax");
        return "datapredios";
    }
}
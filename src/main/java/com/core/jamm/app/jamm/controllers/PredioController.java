package com.core.jamm.app.jamm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PredioController
 */
@Controller
public class PredioController {

    @GetMapping(value = "/menupredios")
    public String menupredios(Model m) {
        m.addAttribute("titulo", "Menú predios");
        return "/predios/menupredios";
    }

    @GetMapping(value = "/pmonoblock")
    public String pmonoblock(Model m) {
        m.addAttribute("titulo","Predios Monoblock");
        return "/predios/pmonoblock";
    }

    @GetMapping(value = "/edifinformatica")
    public String edifinformatica(Model m) {
        m.addAttribute("v_ajax", "Pruebas Ajax");
        m.addAttribute("imagen","edfoinfoweb2.jpg");
        m.addAttribute("ubicacion","");
        m.addAttribute("texto_titulo","");
        return "/predios/edifinformatica";
    }
    @GetMapping (value = "/edifplanetario")
    public String edifplanetario(Model m) {
        m.addAttribute("imagen","edfoplaneweb2.jpg");
        return "/predios/edifinformatica";
    }
}
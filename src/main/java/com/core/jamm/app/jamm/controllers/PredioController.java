package com.core.jamm.app.jamm.controllers;

import com.core.jamm.app.jamm.model.Predio;
import com.core.jamm.app.jamm.service.IPredioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PredioController
 */
@Controller
public class PredioController {

    @Autowired
    private IPredioService predioService;

    @GetMapping(value = "/menupredios")
    public String menupredios(Model m) {
        m.addAttribute("titulo", "Menú predios");
        return "/predios/menupredios";
    }

    @GetMapping(value = "/pmonoblock")
    public String pmonoblock(Model m) {
        m.addAttribute("titulo", "Predios Monoblock");
        return "/predios/pmonoblock";
    }

    @GetMapping(value = "/pmonoblocknv")
    public String pmonoblocknv (Model m) {
        m.addAttribute("titulo", "Predios Monoblock");
        return "/predios/pmonoblocknv";
    }

    @PostMapping(value = "/getprediobyid")
    public String getPredioById(@RequestParam("idpredio") Long idpredio, Model m) {
        Predio predio = null;
        predio = predioService.findOne(idpredio);
        if (predio == null) {
            System.out.println(" VACIO");
        }
        System.out.println(predio.getNombrePredio());
        m.addAttribute("predio", predio);
        /*
         * svg imagen del predio descripcion del predio (Edificion <br> de informatica)
         * url de la ubicación
         */
        return "/predios/getprediobyid";
    }

    @GetMapping(value = "/edifinformatica")
    public String edifinformatica(Model m) {
        m.addAttribute("v_ajax", "Pruebas Ajax");
        m.addAttribute("imagen", "edfoinfoweb2.jpg");
        m.addAttribute("ubicacion", "");
        m.addAttribute("texto_titulo", "");
        return "/predios/edifinformatica";
    }

    @GetMapping(value = "/edifplanetario")
    public String edifplanetario(Model m) {
        m.addAttribute("imagen", "edfoplaneweb2.jpg");
        return "/predios/edifinformatica";
    }
}
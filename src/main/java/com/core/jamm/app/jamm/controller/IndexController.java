package com.core.jamm.app.jamm.controller;

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
        m.addAttribute("titulo", "Bienvenido al sistema JAMM - JC");
        return "index";
    }

}
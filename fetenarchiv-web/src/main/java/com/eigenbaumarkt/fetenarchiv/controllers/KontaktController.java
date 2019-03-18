package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping({"/kontakte"})
@Controller
public class KontaktController {

    private final KontaktService kontaktService;

    public KontaktController(KontaktService kontaktService) {
        this.kontaktService = kontaktService;
    }

    @RequestMapping({"", "/", "/index", "/index.htm", "/index.html"})
    public String listKontakts(Model model){

        Set<Kontakt> kontakte = kontaktService.findAll();
        model.addAttribute("kontakte", kontakte);

        return "kontakte/index";
    }
}

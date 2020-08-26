package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.services.FeteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeteController {

    private final FeteService feteService;

    public FeteController(FeteService feteService) {
        this.feteService = feteService;
    }


    @RequestMapping({"/feten", "/feten/index", "/feten/index.html", "/feten.html"})
    public String listFeten(Model model) {

        model.addAttribute("feten", feteService.findAll());

        return "feten/index";
    }
}

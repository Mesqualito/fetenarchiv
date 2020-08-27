package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Fete;
import com.eigenbaumarkt.fetenarchiv.services.FeteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class FeteController {

    private final FeteService feteService;

    public FeteController(FeteService feteService) {
        this.feteService = feteService;
    }


    @GetMapping({"/feten", "/feten/index", "/feten/index.html", "/feten.html"})
    public String listFeten(Model model) {

        model.addAttribute("feten", feteService.findAll());

        return "feten/index";
    }

    // @ResponseBody liefert entweder JSON (default) oder XML (muss konfiguriert werden)
    @RequestMapping("/api/feten")
    public @ResponseBody Set<Fete> getFetenJson() {

        return feteService.findAll();

    }

}

package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    // best practice: "Injection" der Interfaces benötigter 'Service'-Implementationen
    // "by controller" in finale Objektvariablen bei Erstellung des 'Controller'-Objekts
    // hier: mit genau einer Instanz des 'OwnerService' wird eine Instanz des 'OwnerControllers'
    // erzeugt. Welche Implementation des 'OwnerService'-Interfaces verwendet wird,
    // bestimmt das Spring framework
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.htm", "/index.html"})
    // mit Deklaration des Parameters 'model' fügt Spring MVC
    // automatisch ein Model hinzu
    public String listOwners(Model model){

        // Parameter:
        // - die Bezeichnung einer property im Modell
        // - die angewandte Methode des Service hinter der Bezeichnung
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}

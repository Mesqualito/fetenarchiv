package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Owner;
import com.eigenbaumarkt.fetenarchiv.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.htm", "/index.html"})
    public String listOwners(Model model){

        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);

        return "owners/index";
    }
}

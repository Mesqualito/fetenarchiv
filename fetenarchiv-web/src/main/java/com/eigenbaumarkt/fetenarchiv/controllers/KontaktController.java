package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@RequestMapping({"/kontakte"})
@Controller
public class KontaktController {

    private static final String VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM = "kontakte/createOrUpdateKontaktForm";

    private final KontaktService kontaktService;

    public KontaktController(KontaktService kontaktService) {
        this.kontaktService = kontaktService;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"", "/", "/index", "/index.htm", "/index.html"})
    public String listKontakts(Model model){

        Set<Kontakt> kontakte = kontaktService.findAll();
        model.addAttribute("kontakte", kontakte);

        return "kontakte/index";
    }

    @RequestMapping({"/find"})
    public String findKontakte(Model model){
        model.addAttribute("kontakt", Kontakt.builder().build());
        return "kontakte/findKontakte";
    }

    /*
    @GetMapping
    public String processFindForm(Kontakt kontakt, BindingResult result, Model model) {
        // allow parameterless GET request for '/kontakte' to return all records
        if (kontakt.getLastName() == null) {
            kontakt.setLastName(""); // empty string signifies broadest possible search
        }

        // find kontakte by last name
        List<Kontakt> results = kontaktService.findAllByLastNameLike("%" + kontakt.getLastName() + "%");

        if (results.isEmpty()) {
            // no kontakte found
            result.rejectValue("lastName", "notFound", "not found");
            return "kontakte/findKontakte";
        } else if (results.size() == 1) {
            // 1 kontakt found
            kontakt = results.get(0);
            return "redicret:/kontakte/" + kontakt.getId();
        } else {
            // multiple kontakte found
            model.addAttribute("selections", results);
            return "kontakte/kontakteList";
        }
    }
    */

    @GetMapping("/{kontaktId}")
    public ModelAndView showKontakt(@PathVariable Long kontaktId) {
        ModelAndView mav = new ModelAndView("kontakte/kontaktDetails");
        mav.addObject(kontaktService.findById(kontaktId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("kontakt", Kontakt.builder().build());
        return VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM;
    }

    /*
    @PostMapping("/{kontaktId}/edit")
    public String initUpdateKontaktForm(@PathVariable Long kontaktId, Model model) {
        model.addAttribute(kontaktService.findById(kontaktId));
        return VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{kontaktId}/edit")
    public String processUpdateKontaktForm(@Valid Kontakt kontakt, BindingResult result, @PathVariable Long kontaktId) {
        if (result.hasErrors()) {
            return VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM;
        } else {
            kontakt.setId(kontaktId);
            Kontakt savedKontakt = kontaktService.save(kontakt);
            return "redirect:/kontakte/" + savedKontakt.getId();
        }
    }

     */
}

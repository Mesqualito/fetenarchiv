package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping({"/kontakte"})
@Controller
public class KontaktController {

    private static final String VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM = "kontakte/kontaktAnlegenOderUpdatenForm";

    private final KontaktService kontaktService;

    public KontaktController(KontaktService kontaktService) {
        this.kontaktService = kontaktService;
    }

    /* control 'magic' of Spring framework binding http variables coming in to java objects since Spring 1.2 */
    /* see: https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/WebDataBinder.html */
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        /* SECURITY: we don't want to allow the public available webforms,
        e.g. 'createOrUpdateKontaktForm.html', to address the 'id'-property in our stateless system */
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"/find"})
    public String findKontakte(Model model){
        model.addAttribute("kontakt", Kontakt.builder().build());
        return "kontakte/findKontakte";
    }

    // GetMapping for "/kontakte" ("/kontakte" is set as startpoint/root for this controller)
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
            return "redirect:/kontakte/" + kontakt.getId();
        } else {
            // multiple kontakte found
            model.addAttribute("auswahl", results);
            return "kontakte/kontaktListe";
        }
    }

    @GetMapping("/{kontaktId}")
    public ModelAndView showKontakt(@PathVariable Long kontaktId) {
        ModelAndView mav = new ModelAndView("kontakte/kontaktDetails");
        mav.addObject(kontaktService.findById(kontaktId));
        return mav;
    }

    @GetMapping("/neu")
    public String initCreationForm(Model model) {
        model.addAttribute("kontakt", Kontakt.builder().build());
        return VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM;
    }

    /* @RequestMapping(value="/neu", method = RequestMethod.POST) */
    @PostMapping("/neu")
    public String processCreationForm(@Valid Kontakt kontakt, BindingResult result) {
        if(result.hasErrors()) {
            return VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM;
        } else {
            Kontakt savedKontakt = kontaktService.save(kontakt);
            return "redirect:/kontakte/" + savedKontakt.getId();
        }
    }

    @GetMapping("/{kontaktId}/aendern")
    public String initUpdateKontaktForm(@PathVariable Long kontaktId, Model model) {
        model.addAttribute(kontaktService.findById(kontaktId));
        return VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{kontaktId}/aendern")
    public String processUpdateKontaktForm(@Valid Kontakt kontakt, BindingResult result, @PathVariable Long kontaktId) {
        if (result.hasErrors()) {
            return VIEWS_KONTAKT_CREATE_OR_UPDATE_FORM;
        } else {
            kontakt.setId(kontaktId);
            // when saving, get back the saved object:
            Kontakt savedKontakt = kontaktService.save(kontakt);
            return "redirect:/kontakte/" + savedKontakt.getId();
        }
    }
}

package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.model.Termin;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.TerminService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class TerminController {

    private final TerminService terminService;
    private final MediaService mediaService;

    public TerminController(TerminService terminService, MediaService mediaService) {
        this.terminService = terminService;
        this.mediaService = mediaService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));
            }
        });
    }

    /**
     * Called before each and every @RequestMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that Media object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param mediaId
     * @return Media
     */
    @ModelAttribute("termin")
    public Termin loadMediaWithTermin(@PathVariable("mediaId") Long mediaId, Map<String, Object> model) {
        Media media = mediaService.findById(mediaId);
        model.put("media", media);
        Termin termin = new Termin();
        media.getTerminSet().add(termin);
        termin.setMedia(media);
        return termin;
    }

    // Spring MVC calls method loadMediaWithTermin(...) before initNewTerminForm is called
    @GetMapping("/kontakte/*/medien/{petId}/termine/neu")
    public String initNewTerminForm(@PathVariable("mediaId") Long mediaId, Map<String, Object> model) {
        return "medien/terminAnlegenOderAendernForm";
    }

    // Spring MVC calls method loadMediaWithTermin(...) before processNewTerminForm is called
    @PostMapping("/kontakte/{kontaktId}/medien/{mediaId}/termine/neu")
    public String processNewTerminForm(@Valid Termin termin, BindingResult result) {
        if (result.hasErrors()) {
            return "medien/terminAnlegenOderAendernForm";
        } else {
            terminService.save(termin);
            return "redirect:/kontakte/{kontaktId}";
        }
    }
}

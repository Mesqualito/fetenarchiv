package com.eigenbaumarkt.fetenarchiv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/media"})
public class MediaController {

    @RequestMapping({"", "/", "/index", "/index.htm", "/index.html"})
    public String listMedia(){

        return "media/index";
    }
}
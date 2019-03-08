package com.eigenbaumarkt.fetenarchiv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MediaController {

    @RequestMapping({"/media", "/media/index", "/media/index.htm", "/media/index.html"})
    public String listMedia(){

        return "media/index";
    }
}

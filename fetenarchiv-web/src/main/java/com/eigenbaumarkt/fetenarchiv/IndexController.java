package com.eigenbaumarkt.fetenarchiv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.htm", "index.html"})
    public String index(){

        // "index" tells thymeleaf to deliver
        // 'resources/templates/index.html'
        return "index";
    }
}

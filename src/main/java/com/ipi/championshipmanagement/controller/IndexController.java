package com.ipi.championshipmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    public IndexController() {
    }

    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }
}

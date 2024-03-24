package com.ipi.championshipmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {
    public DetailController() {

    }

    @GetMapping({"/detail"})
    public String index() { return "detail"; }
}

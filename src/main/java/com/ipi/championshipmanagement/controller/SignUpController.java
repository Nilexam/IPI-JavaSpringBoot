package com.ipi.championshipmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    public SignUpController() {
    }

    @GetMapping("/signup")
    public String index() {
        return "signup";
    }
}

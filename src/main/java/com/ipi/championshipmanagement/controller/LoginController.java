package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.User;
import com.ipi.championshipmanagement.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Console;
import java.util.Date;

@Controller
public class LoginController {

    private final HttpSession httpSession;
    private final UserService userService;
    public LoginController(UserService userService, HttpSession httpSession) {
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("/login")
    public String getLogin(Model model, @ModelAttribute @Validated User user) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(Model model, @ModelAttribute @Validated User user, BindingResult bindingResult) {
       if (!bindingResult.hasErrors()) {
           User loginUser = userService.getUserByLogin(user.getLogin());
           System.out.println(user);
           System.out.println(loginUser);
           if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
               httpSession.setAttribute("user", loginUser);
               return "redirect:/index";
           }
       }
        return "login";
    }
}

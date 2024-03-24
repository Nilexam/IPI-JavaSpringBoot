package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.User;
import com.ipi.championshipmanagement.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final UserService userService;
    private final HttpSession httpSession;

    public SignUpController(UserService userService, HttpSession httpSession) {
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("/signup")
    public String getSignup(Model model, @ModelAttribute("user") @Valid User user) {
        return "signup";
    }

    @PostMapping("/signup")
    public String postLogin(Model model, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (userService.emailExists(user.getEmail())) {
                bindingResult.rejectValue("email", "error.email", "Email already exists");
                return "signup";
            }
            if (userService.loginExists(user.getLogin())) {
                bindingResult.rejectValue("login", "error.login", "Login already exists");
                return "signup";
            }
            userService.saveUser(user);
            httpSession.setAttribute("user", user);
            return "redirect:/index";
        }
        return "signup";
    }
}

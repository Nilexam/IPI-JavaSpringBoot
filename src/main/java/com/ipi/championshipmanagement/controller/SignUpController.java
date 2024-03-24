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

import java.util.Objects;

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
        if (isEmpty(user.getFirstName())) {
            bindingResult.rejectValue("firstName", "error.field.empty", "First Name field is empty");
        }
        if (isEmpty(user.getLastName())) {
            bindingResult.rejectValue("lastName", "error.field.empty", "Last Name field is empty");
        }
        if (isEmpty(user.getLogin())) {
            bindingResult.rejectValue("login", "error.field.empty", "Login field is empty");
        }
        if (isEmpty(user.getPassword())) {
            bindingResult.rejectValue("password", "error.field.empty", "Password field is empty");
        }
        if (isEmpty(user.getNickname())) {
            bindingResult.rejectValue("nickname", "error.field.empty", "Nickname field is empty");
        }
        if (isEmpty(user.getEmail())) {
            bindingResult.rejectValue("email", "error.field.empty", "Email field is empty");
        } else if (!isValidEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "error.email.invalid", "Invalid email format");
        }

        if (userService.emailExists(user.getEmail())) {
            bindingResult.rejectValue("email", "error.email.isNotUnique", "Email already exists");
        }
        if (userService.loginExists(user.getLogin())) {
            bindingResult.rejectValue("login", "error.login", "Login already exists");
        }

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        userService.saveUser(user);
        httpSession.setAttribute("user", user);

        return "redirect:/index";
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}

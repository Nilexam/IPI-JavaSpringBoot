package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.Club;
import com.ipi.championshipmanagement.pojos.User;
import com.ipi.championshipmanagement.services.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailController {

    Boolean editing = false;
    
    private final ClubService clubService;

    public DetailController(ClubService clubService) {
        this.clubService = clubService;
    }
    @GetMapping({"/detail"})
    public String index(Model model) {
        Club club = clubService.getClubById(1);

        model.addAttribute("name", club.getName());
        model.addAttribute("editing", editing);
        return "detail";
    }

    @PostMapping({"/toggle"})
    public String toggleEditing(Model model) {
        editing = !editing;
        model.addAttribute("editing", editing);
        return "redirect:/detail";
    }

    @PostMapping({"/save"})
    public String saveEditing(Model model) {
        editing = false;
        model.addAttribute("editing", editing);
        return "redirect:/detail";
    }

    @PostMapping({"/cancel"})
    public String cancelEditing(Model model) {
        editing = false;
        model.addAttribute("editing", editing);
        return "redirect:/detail";
    }
}

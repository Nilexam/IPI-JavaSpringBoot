package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.Club;
import com.ipi.championshipmanagement.pojos.Stadium;
import com.ipi.championshipmanagement.services.ClubService;
import com.ipi.championshipmanagement.services.StadiumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailController {

    Boolean editing = false;
    
    private final ClubService clubService;

    private final StadiumService stadiumService;

    public DetailController(ClubService clubService, StadiumService stadiumService) {
        this.clubService = clubService;
        this.stadiumService = stadiumService;
    }
    @GetMapping({"/detail"})
    public String index(Model model, @RequestParam(name = "id", required = false) Long idClub) {
        Club club = clubService.getClubById(idClub);
        Stadium stadium = club.getStadium();

        System.out.println(stadium);

        model.addAttribute("club", club);
        model.addAttribute("stadium", stadium);
        return "detail";
    }

    @PostMapping({"/detail/toggle"})
    public String toggleEditing(Model model) {
        editing = !editing;
        model.addAttribute("editing", editing);
        return "redirect:/detail";
    }

    @PostMapping({"/detail/save"})
    public String saveEditing(Model model) {
        editing = false;
        model.addAttribute("editing", editing);
        return "redirect:/detail";
    }

    @PostMapping({"/detail/cancel"})
    public String cancelEditing(Model model) {
        editing = false;
        model.addAttribute("editing", editing);
        return "redirect:/detail";
    }
}

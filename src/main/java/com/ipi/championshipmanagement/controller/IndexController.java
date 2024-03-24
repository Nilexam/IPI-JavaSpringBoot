package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.Championship;
import com.ipi.championshipmanagement.services.ChampionshipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final ChampionshipService championshipService;

    public IndexController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    @GetMapping({"/", "index"})
    public String index(Model model) {
        List<Championship> championships= championshipService.findAllChampionships();
        model.addAttribute("championships", championships);
        return "index";
    }
}

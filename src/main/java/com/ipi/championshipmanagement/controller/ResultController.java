package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.Championship;
import com.ipi.championshipmanagement.pojos.Game;
import com.ipi.championshipmanagement.services.ChampionshipService;
import com.ipi.championshipmanagement.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResultController {

    private final GameService gameService;
    private final ChampionshipService championshipService;
    public ResultController(GameService gameService, ChampionshipService championshipService) {

        this.gameService = gameService;
        this.championshipService = championshipService;
    }

    @GetMapping({"/result"})
    public String index(@RequestParam("id") Long id, Model model) {
        List<Championship> championships = championshipService.findAllChampionships();
        Championship currentChampionship = championshipService.findChampionshipById(id);
        List<Game> games = gameService.getGamesByChampionship(currentChampionship);

        model.addAttribute("games", games);
        model.addAttribute("idChampionship", id);
        model.addAttribute("championships", championships);
        model.addAttribute("currChamp", currentChampionship);
        return "result";
    }
}

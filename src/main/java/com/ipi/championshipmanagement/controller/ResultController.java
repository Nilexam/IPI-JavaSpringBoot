package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.Championship;
import com.ipi.championshipmanagement.pojos.Game;
import com.ipi.championshipmanagement.services.ChampionshipService;
import com.ipi.championshipmanagement.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResultController {

    Boolean editing = false;
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

        model.addAttribute("editing", editing);
        model.addAttribute("games", games);
        model.addAttribute("idChampionship", id);
        model.addAttribute("championships", championships);
        model.addAttribute("currChamp", currentChampionship);
        return "result";
    }

    @PostMapping({"/result/toggle"})
    public String toggleEditing(@RequestParam("id") Long id, Model model) {
        editing = !editing;
        model.addAttribute("editing", editing);
        return "redirect:/result?id=" + id;
    }

    @PostMapping({"/result/save"})
    public String saveEditing(@RequestParam("goalClub1") int goalClub1,
                              @RequestParam("goalClub2") int goalClub2,
                              @RequestParam("gameId") int gameId,
                              @RequestParam("id") Long id, Model model) {
        if (goalClub1 < 0 || goalClub2 < 0) {
            model.addAttribute("errorMessage", "Goal values must be positive numbers.");
            return "redirect:/result?id=" + id;
        }

        editing = false;

        Game game = gameService.getGameById(gameId);

        game.setGoalClub1(goalClub1);
        game.setGoalClub2(goalClub2);

        gameService.save(game);

        model.addAttribute("editing", editing);
        return "redirect:/result?id=" + id;
    }

    @PostMapping({"/result/cancel"})
    public String cancelEditing(@RequestParam("id") Long id, Model model) {
        editing = false;
        model.addAttribute("editing", editing);
        return "redirect:/result?id=" + id;
    }
}

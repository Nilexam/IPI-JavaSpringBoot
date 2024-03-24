package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.Championship;
import com.ipi.championshipmanagement.pojos.Club;
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

    String errorMessage = null;
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
        model.addAttribute("errorMessage", errorMessage);
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
                              @RequestParam("nameClub1") String nameClub1,
                              @RequestParam("nameClub2") String nameClub2,
                              @RequestParam("hqClub1") String hqClub1,
                              @RequestParam("hqClub2") String hqClub2,
                              @RequestParam("gameId") int gameId,
                              @RequestParam("id") Long id, Model model) {
        if (goalClub1 < 0 || goalClub2 < 0) {
            errorMessage = "Goal values must be positive numbers.";
            return "redirect:/result?id=" + id;
        }

        if (nameClub1.isEmpty() || nameClub2.isEmpty() || hqClub1.isEmpty() || hqClub2.isEmpty()) {
            errorMessage = "All fields as to be filled.";
            return "redirect:/result?id=" + id;
        }

        editing = false;

        Game game = gameService.getGameById(gameId);
        Club club1 = game.getClub1();
        Club club2 = game.getClub2();

        game.setGoalClub1(goalClub1);
        game.setGoalClub2(goalClub2);
        club1.setName(nameClub1);
        club1.setHeadquarters(hqClub1);
        game.setClub1(club1);
        club2.setName(nameClub2);
        club2.setHeadquarters(hqClub2);
        game.setClub2(club2);

        gameService.save(game);

        model.addAttribute("editing", editing);
        errorMessage = null;
        return "redirect:/result?id=" + id;
    }

    @PostMapping({"/result/cancel"})
    public String cancelEditing(@RequestParam("id") Long id, Model model) {
        editing = false;
        model.addAttribute("editing", editing);
        return "redirect:/result?id=" + id;
    }
}

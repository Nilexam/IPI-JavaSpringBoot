package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.Championship;
import com.ipi.championshipmanagement.pojos.Club;
import com.ipi.championshipmanagement.services.ChampionshipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.LinkedHashMap;


import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class RankingController {

    private final ChampionshipService championshipService;

    public RankingController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    @GetMapping({"/ranking"})
    public String index(Model model, @RequestParam(name = "id", required = false) Long icChamphionship) {
        Championship championship = championshipService.findChampionshipById(icChamphionship);

        if (championship != null && championship.getPointsEquipe() != null) {
            // Trier les points d'équipe par ordre décroissant de la somme des points de chaque club
            Map<Club, Integer> sortedPoints = championship.getPointsEquipe()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Tri inversé
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            championship.setPointsEquipe(sortedPoints);
        }

        model.addAttribute("championship", championship);
        return "ranking";
    }
}

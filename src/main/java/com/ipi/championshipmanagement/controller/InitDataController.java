package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.*;
import com.ipi.championshipmanagement.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

@Controller
public class InitDataController {

    private final CountryService countryService;
    private final ChampionshipService championshipService;
    private final ClubService clubService;
    private final DayService dayService;
    private final GameService gameService;
    private final StadiumService stadiumService;
    private final UserService userService;

    public InitDataController(CountryService countryService, ChampionshipService championshipService, ClubService clubService, DayService dayService, GameService gameService, StadiumService stadiumService, UserService userService) {
        super();
        this.countryService = countryService;
        this.championshipService = championshipService;
        this.clubService = clubService;
        this.dayService = dayService;
        this.gameService = gameService;
        this.stadiumService = stadiumService;
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        Country france = new Country("France", "/img/france.png");
        Country england = new Country("England", "/img/england.png");
        countryService.save(england);
        countryService.save(france);

        Championship ligue1 = new Championship("Ligue 1", "/img/ligue1.png", new Date(), new Date(), "standard", france, new ArrayList<>(), null, null);
        Championship premierLeague = new Championship("Premier League", "/img/premierLeague.png", new Date(), new Date(), "standard", england, new ArrayList<>(), null, null);
        championshipService.save(premierLeague);
        championshipService.save(ligue1);

        Club psg = new Club("Paris Saint-Germain", "1970-08-12", "/img/psg.png", "Mauricio Pochettino", "Nasser Al-Khelaifi", "Professional", "Paris, France", "+33 1 48 03 80 00", "https://www.psg.fr/", null);
        Club liverpool = new Club("Liverpool FC", "1892-06-03", "/img/liverpoolfc.png", "Jurgen Klopp", "Tom Werner", "Professional", "Liverpool, England", "+44 151 260 6677", "https://www.liverpoolfc.com/",  null);
        clubService.save(liverpool);
        clubService.save(psg);

        Map<Club, Integer> pointsLigue1 = new HashMap<>();
        pointsLigue1.put(psg, 3);
        Map<Club, Integer> pointsPremierLeague = new HashMap<>();
        pointsPremierLeague.put(liverpool, 3);

        ligue1.setPointsEquipe(pointsLigue1);
        premierLeague.setPointsEquipe(pointsPremierLeague);

        clubService.save(liverpool);
        clubService.save(psg);

        Day day1 = new Day(1, ligue1);
        Day day2 = new Day(1, premierLeague);
        dayService.save(day1);
        dayService.save(day2);

        Stadium parcDesPrinces = new Stadium("Parc des Princes", "24 Rue du Commandant Guilbaud, 75016 Paris, France", 48712, "+33 1 47 43 71 71", psg);
        parcDesPrinces.setClub(psg);
        Stadium anfield = new Stadium("Anfield", "Anfield Rd, Liverpool L4 0TH, England", 54074, "+44 151 260 6677", liverpool);
        anfield.setClub(liverpool);
        stadiumService.save(anfield);
        stadiumService.save(parcDesPrinces);

        liverpool.setStadium(anfield);
        psg.setStadium(parcDesPrinces);
        clubService.save(liverpool);
        clubService.save(psg);

        Game game1 = new Game(2, 1, parcDesPrinces, psg, liverpool, day1, ligue1);
        Game game2 = new Game(3, 2, anfield, liverpool, psg, day2, premierLeague);
        gameService.save(game1);
        gameService.save(game2);

        Map<Club, Integer> pointsEquipe = new HashMap<>();
        pointsEquipe.put(psg, 10);
        pointsEquipe.put(liverpool, 22);

        ligue1.setPointsEquipe(pointsEquipe);

        championshipService.save(ligue1);

        User user1 = new User(1, "John", "Doe", "johnDoe39", "123456", "jodo", "johndoe@gmail.com");
        userService.saveUser(user1);
    }
}
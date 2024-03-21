package com.ipi.championshipmanagement.controller;

import com.ipi.championshipmanagement.pojos.*;
import com.ipi.championshipmanagement.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Date;

@Controller
public class InitDataController {

    private final CountryService countryService;
    private final ChampionshipService championshipService;
    private final ClubService clubService;
    private final DayService dayService;
    private final GameService gameService;
    private final StadiumService stadiumService;

    public InitDataController(CountryService countryService, ChampionshipService championshipService, ClubService clubService, DayService dayService, GameService gameService, StadiumService stadiumService) {
        super();
        this.countryService = countryService;
        this.championshipService = championshipService;
        this.clubService = clubService;
        this.dayService = dayService;
        this.gameService = gameService;
        this.stadiumService = stadiumService;
    }

    @PostConstruct
    private void init() {
        Country france = new Country("France", "/img/france.png");
        Country england = new Country("England", "/img/england.png");
        countryService.save(england);
        countryService.save(france);

        Championship ligue1 = new Championship("Ligue 1", "/img/ligue1.png", new Date(), new Date(), 3, 0, 1, "standard", france, null, null);
        Championship premierLeague = new Championship("Premier League", "/img/premierLeague.png", new Date(), new Date(), 3, 0, 1, "standard", england, null, null);
        championshipService.save(premierLeague);
        championshipService.save(ligue1);

        Club psg = new Club("Paris Saint-Germain", "1970-08-12", "/img/psg.png", "Mauricio Pochettino", "Nasser Al-Khelaifi", "Professional", "Paris, France", "+33 1 48 03 80 00", "https://www.psg.fr/");
        Club liverpool = new Club("Liverpool FC", "1892-06-03", "/img/liverpoolfc.png", "Jurgen Klopp", "Tom Werner", "Professional", "Liverpool, England", "+44 151 260 6677", "https://www.liverpoolfc.com/");
        clubService.save(liverpool);
        clubService.save(psg);

        psg.setChampionships(Arrays.asList(ligue1));
        liverpool.setChampionships(Arrays.asList(premierLeague));
        clubService.save(liverpool);
        clubService.save(psg);

        Day day1 = new Day(1, ligue1);
        Day day2 = new Day(1, premierLeague);
        dayService.save(day1);
        dayService.save(day2);

        Stadium parcDesPrinces = new Stadium("Parc des Princes", "24 Rue du Commandant Guilbaud, 75016 Paris, France", 48712, "+33 1 47 43 71 71");
        parcDesPrinces.setClub(psg);
        Stadium anfield = new Stadium("Anfield", "Anfield Rd, Liverpool L4 0TH, England", 54074, "+44 151 260 6677");
        anfield.setClub(liverpool);
        stadiumService.save(anfield);
        stadiumService.save(parcDesPrinces);

        Game game1 = new Game(2, 1, parcDesPrinces, psg, liverpool, day1, ligue1);
        Game game2 = new Game(3, 2, anfield, liverpool, psg, day2, premierLeague);
        gameService.save(game1);
        gameService.save(game2);
    }
}

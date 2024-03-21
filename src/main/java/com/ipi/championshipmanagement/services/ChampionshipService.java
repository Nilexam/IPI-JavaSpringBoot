package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.Championship;
import com.ipi.championshipmanagement.pojos.Game;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ChampionshipService {
    Championship addChampionship(Championship championship);
    Championship findChampionshipById(long id);
    Championship findChampionshipByName(String name);
    List<Championship> findAllChampionships();
    List<Game> findGames(Championship championship);
    List<Championship> findChampionshipsByCountry(String countryName);

    void save(Championship ligue1);
}

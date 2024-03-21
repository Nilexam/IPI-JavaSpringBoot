package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.ChampionshipDao;
import com.ipi.championshipmanagement.dao.GameDao;
import com.ipi.championshipmanagement.pojos.Championship;
import com.ipi.championshipmanagement.pojos.Game;
import com.ipi.championshipmanagement.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChampionshipServiceImpl implements ChampionshipService {

    private ChampionshipDao championshipDao;
    private GameDao gameDao;

    @Override
    public Championship addChampionship(Championship championship) {
        return null;
    }

    @Override
    public Championship findChampionshipById(long id) {
        return championshipDao.findById(id).orElse(null);
    }

    @Override
    public Championship findChampionshipByName(String name) {
        return championshipDao.findByName(name);
    }

    @Override
    public List<Championship> findAllChampionships() {
        return championshipDao.findAll();
    }

    @Override
    public List<Game> findGames(Championship championship) {
        return gameDao.findByChampionship(championship);
    }

    @Override
    public List<Championship> findChampionshipsByCountry(String countryName) {
        return null;
    }
}

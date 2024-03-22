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

    private final ChampionshipDao championshipDao;
    private final GameDao gameDao;

    public ChampionshipServiceImpl(ChampionshipDao championshipDao, GameDao gameDao) {
        this.championshipDao = championshipDao;
        this.gameDao = gameDao;
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

    @Override
    public void save(Championship championship) {
        championshipDao.save(championship);
    }
}

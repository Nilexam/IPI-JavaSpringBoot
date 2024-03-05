package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.GameDao;
import com.ipi.championshipmanagement.pojos.Game;
import com.ipi.championshipmanagement.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public List<Game> getAllGames() {
        return (List<Game>) gameDao.findAll();
    }

    @Override
    public Game getGameById(long gameId) {
        Optional<Game> optionalGame = gameDao.findById(gameId);
        return optionalGame.orElse(null);
    }

    @Override
    public Game saveGame(Game game) {
        return gameDao.save(game);
    }

    @Override
    public void deleteGame(long gameId) {
        gameDao.deleteById(gameId);
    }

}

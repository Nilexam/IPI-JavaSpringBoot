package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.Game;

import java.util.List;

public interface GameService {
    List<Game> getAllGames();

    Game getGameById(long gameId);

    Game saveGame(Game game);

    void deleteGame(long gameId);

    void save(Game game);
}

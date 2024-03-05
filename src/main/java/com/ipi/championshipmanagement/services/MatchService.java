package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.Match;

import java.util.List;

public interface MatchService {
    List<Match> getAllMatches();

    Match getMatchById(long matchId);

    Match saveMatch(Match match);

    void deleteMatch(long matchId);

}

package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.MatchDao;
import com.ipi.championshipmanagement.pojos.Match;
import com.ipi.championshipmanagement.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Override
    public List<Match> getAllMatches() {
        return (List<Match>) matchDao.findAll();
    }

    @Override
    public Match getMatchById(long matchId) {
        Optional<Match> optionalMatch = matchDao.findById(matchId);
        return optionalMatch.orElse(null);
    }

    @Override
    public Match saveMatch(Match match) {
        return matchDao.save(match);
    }

    @Override
    public void deleteMatch(long matchId) {
        matchDao.deleteById(matchId);
    }

}

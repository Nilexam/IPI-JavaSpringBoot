package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.ClubDao;
import com.ipi.championshipmanagement.pojos.Club;
import com.ipi.championshipmanagement.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubDao clubDao;

    @Override
    public List<Club> getAllClubs() {
        return (List<Club>) clubDao.findAll();
    }

    @Override
    public Club getClubById(long clubId) {
        Optional<Club> optionalClub = clubDao.findById(clubId);
        return optionalClub.orElse(null);
    }

    @Override
    public Club saveClub(Club club) {
        return clubDao.save(club);
    }

    @Override
    public void deleteClub(long clubId) {
        clubDao.deleteById(clubId);
    }

}

package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.StadiumDao;
import com.ipi.championshipmanagement.pojos.Stadium;
import com.ipi.championshipmanagement.pojos.Club;
import com.ipi.championshipmanagement.services.StadiumService;
import com.ipi.championshipmanagement.services.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StadiumServiceImpl implements StadiumService {

    private final StadiumDao stadiumDao;
    private final ClubService clubService;

    public StadiumServiceImpl(StadiumDao stadiumDao, ClubService clubService) {
        this.stadiumDao = stadiumDao;
        this.clubService = clubService;
    }

    @Override
    public List<Stadium> getAllStadiums() {
        return (List<Stadium>) stadiumDao.findAll();
    }

    @Override
    public Stadium getStadiumById(long stadiumId) {
        Optional<Stadium> optionalStadium = stadiumDao.findById(stadiumId);
        return optionalStadium.orElse(null);
    }

    @Override
    public Stadium saveStadium(Stadium stadium) {
        return stadiumDao.save(stadium);
    }

    @Override
    public void deleteStadium(long stadiumId) {
        stadiumDao.deleteById(stadiumId);
    }

    @Override
    public void save(Stadium stadium) {
        stadiumDao.save(stadium);
    }

    @Override
    public Stadium getStadiumByIdClub(Long clubId) {
        List<Stadium> allStadiums = getAllStadiums();
        for (Stadium stadium : allStadiums) {
            if (stadium.getClub() != null && stadium.getClub().getId() == clubId) {
                return stadium;
            }
        }
        return null;
    }



}

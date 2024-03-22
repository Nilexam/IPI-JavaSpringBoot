package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.StadiumDao;
import com.ipi.championshipmanagement.pojos.Stadium;
import com.ipi.championshipmanagement.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumServiceImpl implements StadiumService {

    private final StadiumDao stadiumDao;

    public StadiumServiceImpl(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
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

}

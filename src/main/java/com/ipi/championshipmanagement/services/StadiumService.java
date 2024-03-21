package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.Stadium;

import java.util.List;

public interface StadiumService {
    List<Stadium> getAllStadiums();

    Stadium getStadiumById(long stadiumId);

    Stadium saveStadium(Stadium stadium);

    void deleteStadium(long stadiumId);

    void save(Stadium anfield);
}

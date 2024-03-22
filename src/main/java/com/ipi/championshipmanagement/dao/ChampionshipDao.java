package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChampionshipDao extends JpaRepository<Championship, Long> {
    Championship findByName(String name);

    List<Championship> findByCountry(Country country);

    List<Championship> findByDay(Day day);

    List<Championship> findByClub(Club club);
}

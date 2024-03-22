package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.Club;

import java.util.List;

public interface ClubService {
    List<Club> getAllClubs();

    Club getClubById(long clubId);

    Club saveClub(Club club);

    void deleteClub(long clubId);

    void save(Club club);
}

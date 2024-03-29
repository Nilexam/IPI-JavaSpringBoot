package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.Club;
import com.ipi.championshipmanagement.pojos.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumDao extends JpaRepository<Stadium, Long> {
    Stadium findByClub(Club club);
}

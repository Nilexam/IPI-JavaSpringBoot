package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubDao extends JpaRepository<Club, Long> {
}

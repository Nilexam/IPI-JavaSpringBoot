package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchDao extends JpaRepository<Match, Long> {
}

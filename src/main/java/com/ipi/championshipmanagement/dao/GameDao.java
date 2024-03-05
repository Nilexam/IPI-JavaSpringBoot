package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game, Long> {
}

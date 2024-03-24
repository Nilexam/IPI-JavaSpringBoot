package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDao extends JpaRepository<Day, Long> {
}

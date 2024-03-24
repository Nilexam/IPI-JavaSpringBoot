package com.ipi.championshipmanagement.dao;

import com.ipi.championshipmanagement.pojos.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Long> {
}

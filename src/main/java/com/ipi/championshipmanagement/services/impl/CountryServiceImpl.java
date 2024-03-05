package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.CountryDao;
import com.ipi.championshipmanagement.pojos.Country;
import com.ipi.championshipmanagement.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> getAllCountries() {
        return (List<Country>) countryDao.findAll();
    }

    @Override
    public Country getCountryById(long countryId) {
        Optional<Country> optionalCountry = countryDao.findById(countryId);
        return optionalCountry.orElse(null);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryDao.save(country);
    }

    @Override
    public void deleteCountry(long countryId) {
        countryDao.deleteById(countryId);
    }

}

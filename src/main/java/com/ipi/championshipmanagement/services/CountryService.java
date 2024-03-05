package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    Country getCountryById(long countryId);

    Country saveCountry(Country country);

    void deleteCountry(long countryId);

}

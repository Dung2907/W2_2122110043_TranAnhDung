package com.trananhdung.demo.service;

import java.util.List;

import com.trananhdung.demo.entity.Country;

public interface CountryService {
    Country addCountry(Country country);
    
    Country getCountryById(Long countryId);
    
    List<Country> getAllCountries();
    
    Country updateCountry(Long countryId, Country updatedCountry);
    
    void deleteCountry(Long countryId);
}

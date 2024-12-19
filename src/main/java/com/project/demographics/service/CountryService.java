package com.project.demographics.service;

import com.project.demographics.entity.Country;
import com.project.demographics.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public ResponseEntity<?> createCountry(Country country) {
        if (country.getCode() == null || country.getName() == null || country.getContinent() == null ||
            country.getRegion() == null || country.getSurfaceArea() == null || country.getPopulation() == null) {
            return ResponseEntity.badRequest().body("{\"message\": \"Missing fields.\"}");
        }

        if (countryRepository.existsById(country.getCode())) {
            return ResponseEntity.badRequest().body("{\"message\": \"Duplicate Code value.\"}");
        }

        return ResponseEntity.ok(countryRepository.save(country));
    }
}
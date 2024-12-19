package com.project.demographics.service;

import com.project.demographics.entity.City;
import com.project.demographics.entity.Country;
import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.entity.CountryLanguageId;
import com.project.demographics.repository.CityRepository;
import com.project.demographics.repository.CountryLanguageRepository;
import com.project.demographics.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final CountryLanguageRepository countryLanguageRepository;

    public CountryService(CountryRepository countryRepository, CityRepository cityRepository, CountryLanguageRepository countryLanguageRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<Country> getAllCountriesWithDetails() {
        List<Country> countries = countryRepository.findAll();
        for (Country country : countries) {
            List<City> cities = cityRepository.findByCountryCode(country.getCode());
            List<CountryLanguage> languages = countryLanguageRepository.findByCountryCode(country.getCode());
            country.setCities(cities);
            country.setLanguages(languages);
        }
        return countries;
    }

    @Transactional
    public void deleteCountryLanguage(String countryCode, String language) {
        countryLanguageRepository.deleteById(new CountryLanguageId(countryCode, language));
    }

    // Add createCountry method here
    public ResponseEntity<?> createCountry(Country country) {
        if (country.getCode() == null || country.getName() == null || country.getContinent() == null ||
            country.getRegion() == null || country.getSurfaceArea() == null || country.getPopulation() == null) {
            return ResponseEntity.badRequest().body("{\"message\": \"Missing fields.\"}");
        }

        // Check if country already exists by code
        if (countryRepository.existsById(country.getCode())) {
            return ResponseEntity.badRequest().body("{\"message\": \"Duplicate country code.\"}");
        }

        countryRepository.save(country);
        return ResponseEntity.ok(country);
    }
}

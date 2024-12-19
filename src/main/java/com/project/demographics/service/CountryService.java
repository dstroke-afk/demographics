package com.project.demographics.service;

import com.project.demographics.entity.City;
import com.project.demographics.entity.Country;
import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.repository.CityRepository;
import com.project.demographics.repository.CountryLanguageRepository;
import com.project.demographics.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            country.setCities(cities);

            List<CountryLanguage> languages = countryLanguageRepository.findByIdCountryCode(country.getCode());
            country.setCountryLanguages(languages);
        }
        return countries;
    }

    public Optional<Country> getCountryWithDetailsByName(String name) {
        Optional<Country> optionalCountry = countryRepository.findByName(name);
        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            List<City> cities = cityRepository.findByCountryCode(country.getCode());
            country.setCities(cities);

            List<CountryLanguage> languages = countryLanguageRepository.findByIdCountryCode(country.getCode());
            country.setCountryLanguages(languages);

            return Optional.of(country);
        }
        return Optional.empty();
    }
}
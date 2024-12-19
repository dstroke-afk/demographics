package com.project.demographics.service;

import com.project.demographics.entity.City;
import com.project.demographics.entity.Country;
import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.repository.CityRepository;
import com.project.demographics.repository.CountryLanguageRepository;
import com.project.demographics.repository.CountryRepository;
import org.springframework.stereotype.Service;

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
}

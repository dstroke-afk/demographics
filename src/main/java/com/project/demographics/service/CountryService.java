package com.project.demographics.service;

import com.project.demographics.entity.City;
import com.project.demographics.entity.Country;
import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.entity.CountryLanguageId;
import com.project.demographics.repository.CityRepository;
import com.project.demographics.repository.CountryLanguageRepository;
import com.project.demographics.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Country updateCountry(String code, Country updatedCountry) {
        return countryRepository.findById(code).map(country -> {
            country.setName(updatedCountry.getName());
            country.setContinent(updatedCountry.getContinent());
            country.setRegion(updatedCountry.getRegion());
            country.setSurfaceArea(updatedCountry.getSurfaceArea());
            country.setIndepYear(updatedCountry.getIndepYear());
            country.setPopulation(updatedCountry.getPopulation());
            country.setLifeExpectancy(updatedCountry.getLifeExpectancy());
            country.setGnp(updatedCountry.getGnp());
            country.setGnpOld(updatedCountry.getGnpOld());
            country.setLocalName(updatedCountry.getLocalName());
            country.setGovernmentForm(updatedCountry.getGovernmentForm());
            country.setHeadOfState(updatedCountry.getHeadOfState());
            country.setCapital(updatedCountry.getCapital());
            country.setCode2(updatedCountry.getCode2());
            return countryRepository.save(country);
        }).orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.findById(code).ifPresent(country -> {
            cityRepository.deleteAllByCountryCode(code);
            countryLanguageRepository.deleteAllByIdCountryCode(code);
            countryRepository.delete(country);
        });
    }

    @Transactional
    public City updateCity(int id, City updatedCity) {
        return cityRepository.findById(id).map(city -> {
            city.setName(updatedCity.getName());
            city.setCountryCode(updatedCity.getCountryCode());
            city.setDistrict(updatedCity.getDistrict());
            city.setPopulation(updatedCity.getPopulation());
            return cityRepository.save(city);
        }).orElseThrow(() -> new RuntimeException("City not found"));
    }

    @Transactional
    public void deleteCity(int id) {
        cityRepository.deleteById(id);
    }

    @Transactional
    public CountryLanguage updateCountryLanguage(String countryCode, String language, CountryLanguage updatedCountryLanguage) {
        return countryLanguageRepository.findById(new CountryLanguageId(countryCode, language)).map(countryLanguage -> {
            countryLanguage.setIsOfficial(updatedCountryLanguage.isOfficial());
            countryLanguage.setPercentage(updatedCountryLanguage.getPercentage());
            return countryLanguageRepository.save(countryLanguage);
        }).orElseThrow(() -> new RuntimeException("CountryLanguage not found"));
    }

    @Transactional
    public void deleteCountryLanguage(String countryCode, String language) {
        countryLanguageRepository.deleteById(new CountryLanguageId(countryCode, language));
    }
}

package com.project.demographics.service;

import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.repository.CountryLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLanguageService {
    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<CountryLanguage> getCountryLanguagesByCountryCode(String code) {
        return countryLanguageRepository.findByCountryCode(code);
    }
}

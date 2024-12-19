package com.project.demographics.service;

import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.entity.CountryLanguageId;
import com.project.demographics.repository.CountryLanguageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<CountryLanguage> getAllCountryLanguages() {
        return countryLanguageRepository.findAll();
    }

    public List<CountryLanguage> getCountryLanguagesByCountryCode(String code) {
        return countryLanguageRepository.findByIdCountryCode(code);
    }

    public ResponseEntity<?> createCountryLanguage(CountryLanguage countryLanguage) {
        if (countryLanguage.getId() == null || countryLanguage.getId().getCountryCode() == null ||
            countryLanguage.getId().getLanguage() == null || countryLanguage.getPercentage() == 0) {
            return ResponseEntity.badRequest().body("{\"message\": \"Missing fields.\"}");
        }

        CountryLanguageId id = new CountryLanguageId(
                countryLanguage.getId().getCountryCode(),
                countryLanguage.getId().getLanguage()
        );

        if (countryLanguageRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("{\"message\": \"Duplicate CountryCode or Language value.\"}");
        }

        return ResponseEntity.ok(countryLanguageRepository.save(countryLanguage));
    }
}
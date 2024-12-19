package com.project.demographics.controller;

import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.service.CountryLanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countrylanguage")
public class CountryLanguageController {
    private final CountryLanguageService countryLanguageService;

    public CountryLanguageController(CountryLanguageService countryLanguageService) {
        this.countryLanguageService = countryLanguageService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<CountryLanguage>> getCountryLanguagesByCountryCode(@PathVariable String code) {
        List<CountryLanguage> countryLanguages = countryLanguageService.getCountryLanguagesByCountryCode(code);
        return ResponseEntity.ok(countryLanguages);
    }
}

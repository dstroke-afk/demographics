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

    @GetMapping
    public ResponseEntity<List<CountryLanguage>> getAllCountryLanguages() {
        return ResponseEntity.ok(countryLanguageService.getAllCountryLanguages());
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<CountryLanguage>> getCountryLanguagesByCountryCode(@PathVariable String code) {
        return ResponseEntity.ok(countryLanguageService.getCountryLanguagesByCountryCode(code));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCountryLanguage(@RequestBody CountryLanguage countryLanguage) {
        return countryLanguageService.createCountryLanguage(countryLanguage);
    }
}
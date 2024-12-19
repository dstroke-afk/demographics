package com.project.demographics.controller;


import com.project.demographics.entity.City;
import com.project.demographics.entity.Country;
import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountriesWithDetails();
    }

    @GetMapping("/countries/{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable String name) {
        return countryService.getCountryWithDetailsByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/country/update/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @RequestBody Country updatedCountry) {
        return ResponseEntity.ok(countryService.updateCountry(code, updatedCountry));
    }

    @DeleteMapping("/country/delete/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/city/update/{id}")
    public ResponseEntity<City> updateCity(@PathVariable int id, @RequestBody City updatedCity) {
        return ResponseEntity.ok(countryService.updateCity(id, updatedCity));
    }

    @DeleteMapping("/city/delete/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable int id) {
        countryService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/countrylanguage/update/{countryCode}/{language}")
    public ResponseEntity<CountryLanguage> updateCountryLanguage(@PathVariable String countryCode, @PathVariable String language, @RequestBody CountryLanguage updatedCountryLanguage) {
        return ResponseEntity.ok(countryService.updateCountryLanguage(countryCode, language, updatedCountryLanguage));
    }

    @DeleteMapping("/countrylanguage/delete/{countryCode}/{language}")
    public ResponseEntity<Void> deleteCountryLanguage(@PathVariable String countryCode, @PathVariable String language) {
        countryService.deleteCountryLanguage(countryCode, language);
        return ResponseEntity.noContent().build();
    }
}
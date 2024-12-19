package com.project.demographics.controller;

import com.project.demographics.entity.Country;
import com.project.demographics.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
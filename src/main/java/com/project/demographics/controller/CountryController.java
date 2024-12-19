package com.project.demographics.controller;

import com.project.demographics.entity.Country;
import com.project.demographics.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountriesWithDetails() {
        return ResponseEntity.ok(countryService.getAllCountriesWithDetails());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getCountryByNameWithDetails(@PathVariable String name) {
        return countryService.getCountryWithDetailsByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }
}
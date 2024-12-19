package com.project.demographics.controller;

import com.project.demographics.entity.Country;
import com.project.demographics.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }
}

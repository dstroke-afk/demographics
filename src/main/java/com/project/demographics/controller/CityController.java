package com.project.demographics.controller;

import com.project.demographics.entity.City;
import com.project.demographics.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<City>> getCitiesByCountryCode(@PathVariable String code) {
        return ResponseEntity.ok(cityService.getCitiesByCountryCode(code));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }
}
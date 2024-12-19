package com.project.demographics.service;

import com.project.demographics.entity.City;
import com.project.demographics.repository.CityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<City> getCitiesByCountryCode(String code) {
        return cityRepository.findByCountryCode(code);
    }

    public ResponseEntity<?> createCity(City city) {
        if (city.getId() == null || city.getName() == null || city.getCountryCode() == null ||
            city.getDistrict() == null || city.getPopulation() == null) {
            return ResponseEntity.badRequest().body("{\"message\": \"Missing fields.\"}");
        }

        if (cityRepository.existsById(city.getId())) {
            return ResponseEntity.badRequest().body("{\"message\": \"Duplicate ID value.\"}");
        }

        return ResponseEntity.ok(cityRepository.save(city));
    }
}
package com.project.demographics.repository;

import com.project.demographics.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByCountryCode(String countryCode);
}
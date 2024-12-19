package com.project.demographics.repository;

import com.project.demographics.entity.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {
    List<CountryLanguage> findByIdCountryCode(String countryCode);
}
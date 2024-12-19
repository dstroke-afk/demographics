package com.project.demographics.repository;

import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.entity.CountryLanguageId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
    List<CountryLanguage> findByIdCountryCode(String countryCode);

    @Transactional
    void deleteAllByIdCountryCode(String countryCode); // Added delete method
}
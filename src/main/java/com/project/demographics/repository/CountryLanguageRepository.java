package com.project.demographics.repository;

import com.project.demographics.entity.CountryLanguage;
import com.project.demographics.entity.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    // Add a method to fetch country languages by CountryCode
    @Query("SELECT cl FROM CountryLanguage cl WHERE cl.countryCode = :code")
    List<CountryLanguage> findByCountryCode(@Param("code") String code);
}

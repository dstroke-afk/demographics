package com.project.demographics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @Column(name = "isofficial")
    private boolean isOfficial;

    private float percentage;
}

@Embeddable
@Data
class CountryLanguageId {
    @Column(name = "countrycode")
    private String countryCode;

    private String language;
}
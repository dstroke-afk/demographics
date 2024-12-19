package com.project.demographics.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    private String code;

    private String name;
    private String continent;
    private String region;

    @Column(name = "surfacearea")
    private float surfaceArea;

    @Column(name = "indepyear")
    private Integer indepYear;

    private int population;

    @Column(name = "lifeexpectancy")
    private Float lifeExpectancy;

    private Float gnp;

    @Column(name = "gnpold")
    private Float gnpOld;

    @Column(name = "localname")
    private String localName;

    @Column(name = "governmentform")
    private String governmentForm;

    @Column(name = "headofstate")
    private String headOfState;

    private Integer capital;

    @Column(name = "code2")
    private String code2;

    @Transient
    private List<City> cities;

    @Transient
    private List<CountryLanguage> countryLanguages;
}

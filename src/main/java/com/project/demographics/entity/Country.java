package com.project.demographics.entity;

import jakarta.persistence.*;


import java.util.List;


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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Integer getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Integer indepYear) {
		this.indepYear = indepYear;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Float getGnp() {
		return gnp;
	}

	public void setGnp(Float gnp) {
		this.gnp = gnp;
	}

	public Float getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(Float gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<CountryLanguage> getCountryLanguages() {
		return countryLanguages;
	}

	public void setCountryLanguages(List<CountryLanguage> countryLanguages) {
		this.countryLanguages = countryLanguages;
	}
    
    
}

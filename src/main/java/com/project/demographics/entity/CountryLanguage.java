package com.project.demographics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @Column(name = "isofficial")
    private boolean isOfficial;

    private float percentage;

	public CountryLanguageId getId() {
		return id;
	}

	public void setId(CountryLanguageId id) {
		this.id = id;
	}

	public boolean isOfficial() {
		return isOfficial;
	}

	public void setOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
    
    
}

@Embeddable
class CountryLanguageId {
    @Column(name = "countrycode")
    private String countryCode;

    private String language;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
    
    
}
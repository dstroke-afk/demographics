package com.project.demographics.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "countrylanguage")
@IdClass(CountryLanguageId.class)
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    private boolean isOfficial;
    private float percentage;

    // Getters and setters
    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public static class CountryLanguageId {
        private String countryCode;
        private String language;

        public CountryLanguageId() {
        }

        public CountryLanguageId(String countryCode, String language) {
            this.countryCode = countryCode;
            this.language = language;
        }

        // Getters, setters, equals, and hashCode
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CountryLanguageId that = (CountryLanguageId) o;

            if (!countryCode.equals(that.countryCode)) return false;
            return language.equals(that.language);
        }

        @Override
        public int hashCode() {
            int result = countryCode.hashCode();
            result = 31 * result + language.hashCode();
            return result;
        }
    }
}
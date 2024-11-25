package pe.edu.i201910802.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CountryLanguageId {
    private String countryCode;
    private String language;

    public CountryLanguageId() {}

    public CountryLanguageId(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

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
        return countryCode.equals(that.countryCode) && language.equals(that.language);
    }

    @Override
    public int hashCode() {
        return 31 * countryCode.hashCode() + language.hashCode();
    }
}

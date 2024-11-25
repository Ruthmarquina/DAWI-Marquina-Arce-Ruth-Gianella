package pe.edu.i201910802.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "Code")
    private String code; // Clave primaria

    @Column(name = "Name")
    private String name;

    @Column(name = "Continent")
    private String continent;

    @Column(name = "Region")
    private String region;

    @Column(name = "SurfaceArea")
    private Double surfaceArea;

    @Column(name = "IndepYear")
    private Integer independYear;

    @Column(name = "Population")
    private Integer population;

    @Column(name = "LifeExpectancy")
    private Double lifeExpectancy;

    @Column(name = "GNP")
    private Double gnp;

    @Column(name = "GNPOld")
    private Double gnpoOld;

    @Column(name = "LocalName")
    private String localName;

    @Column(name = "GovernmentForm")
    private String governmentForm;

    @Column(name = "HeadOfState")
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2")
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities; // Relación bidireccional con la entidad City

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<CountryLanguage> countryLanguages;

    public Country() {}

    public Country(String code, String name, String continent, String region, Double surfaceArea, Integer independYear, Integer population, Double lifeExpectancy, Double gnp, Double gnpoOld, String localName, String governmentForm, String headOfState, Integer capital, String code2, Set<City> cities, Set<CountryLanguage> countryLanguages) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.independYear = independYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpoOld = gnpoOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
        this.cities = cities;
        this.countryLanguages = countryLanguages;
    }

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

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getIndependYear() {
        return independYear;
    }

    public void setIndependYear(Integer independYear) {
        this.independYear = independYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Double getGnpoOld() {
        return gnpoOld;
    }

    public void setGnpoOld(Double gnpoOld) {
        this.gnpoOld = gnpoOld;
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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<CountryLanguage> getCountryLanguages() {
        return countryLanguages;
    }

    public void setCountryLanguages(Set<CountryLanguage> countryLanguages) {
        this.countryLanguages = countryLanguages;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", independYear=" + independYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", gnp=" + gnp +
                ", gnpoOld=" + gnpoOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}

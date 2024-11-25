package pe.edu.I201910802.cl1_jpa_data_marquina_ruth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "country")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country {
    @Id
    @Column(name = "Code", columnDefinition = "CHAR(3)")
    private String code;

    @Column(length = 52, nullable = false)
    private String name;

    @Column(length = 13, nullable = false)
    private String continent;

    @Column(length = 26, nullable = false)
    private String region;

    @Column(name = "SurfaceArea", nullable = false)
    private Float surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;

    @Column(nullable = false)
    private Integer population;

    @Column(name = "LifeExpectancy")
    private Float lifeExpectancy;

    @Column(nullable = false)
    private Float gnp;

    @Column(name = "GNPOld")
    private Float gnpOld;

    @Column(name = "LocalName", length = 45, nullable = false)
    private String localName;

    @Column(name = "GovernmentForm", length = 45, nullable = false)
    private String governmentForm;

    @Column(name = "HeadOfState", length = 60)
    private String headOfState;

    @Column(nullable = true)
    private Integer capital;

    @Column(name = "Code2", length = 2)
    private String code2;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @OneToMany(mappedBy = "country")
    private List<CountryLanguage> languages;
}

package pe.edu.I201910802.cl1_jpa_data_marquina_ruth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 35, nullable = false)
    private String name;

    @Column(name = "CountryCode", columnDefinition = "CHAR(3)")
    private String countryCode;

    @Column(length = 20, nullable = false)
    private String district;

    @Column(nullable = false)
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;
}

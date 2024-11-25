package pe.edu.I201910802.cl1_jpa_data_marquina_ruth.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryLanguageId {

    private String countryCode;
    private String language;

}

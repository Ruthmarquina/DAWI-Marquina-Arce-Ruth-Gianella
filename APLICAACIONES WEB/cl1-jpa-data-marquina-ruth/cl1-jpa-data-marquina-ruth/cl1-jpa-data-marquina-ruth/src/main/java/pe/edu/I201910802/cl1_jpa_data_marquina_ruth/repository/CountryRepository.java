package pe.edu.I201910802.cl1_jpa_data_marquina_ruth.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.I201910802.cl1_jpa_data_marquina_ruth.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}

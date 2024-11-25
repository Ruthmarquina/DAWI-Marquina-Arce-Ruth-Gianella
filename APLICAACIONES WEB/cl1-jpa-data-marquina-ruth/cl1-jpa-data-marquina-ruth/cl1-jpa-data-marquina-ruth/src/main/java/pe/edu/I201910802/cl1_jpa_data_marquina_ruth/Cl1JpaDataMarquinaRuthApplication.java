package pe.edu.I201910802.cl1_jpa_data_marquina_ruth;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.I201910802.cl1_jpa_data_marquina_ruth.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataMarquinaRuthApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataMarquinaRuthApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("La lista de los paises que tenemos");
		countryRepository.findAll().forEach(country -> {
			System.out.println("Pais: " + country.getName());
		});


		System.out.println("\n Idiomas en Argentina o Perú ");
		countryRepository.findById("ARG").ifPresentOrElse(
				country -> country.getLanguages().forEach(lang ->
						System.out.println("Lengua en Argentina: " + lang.getLanguage())),
				() -> countryRepository.findById("PER").ifPresent(per ->
						per.getLanguages().forEach(lang ->
								System.out.println("Lengua en Perú: " + lang.getLanguage()))
				)
		);


		System.out.println("\n Eliminamos Colombia y Argentina ");
		List<String> codesList = List.of("COL", "ARG");
		String formattedCodes = codesList.stream()
				.map(code -> "'" + code + "'")
				.collect(Collectors.joining(","));

		try {
			entityManager.getTransaction().begin();

			String[] queries = {
					"DELETE FROM city WHERE CountryCode IN (" + formattedCodes + ")",
					"DELETE FROM countrylanguage WHERE CountryCode IN (" + formattedCodes + ")",
					"DELETE FROM country WHERE Code IN (" + formattedCodes + ")"
			};

			for (String query : queries) {
				entityManager.createNativeQuery(query).executeUpdate();
			}

			entityManager.getTransaction().commit();
			System.out.println("Eliminación exitosa");
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}

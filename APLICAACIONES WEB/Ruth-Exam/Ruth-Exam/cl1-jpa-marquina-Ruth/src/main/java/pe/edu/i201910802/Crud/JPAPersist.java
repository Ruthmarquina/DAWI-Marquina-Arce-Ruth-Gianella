package pe.edu.i201910802.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import pe.edu.i201910802.Entity.*;

import java.util.Arrays;
import java.util.List;

public class JPAPersist {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            // Datos del país
            Country country = new Country();
            country.setCode("IMF");
            country.setName("I Federationshet");
            country.setContinent("Asia");
            country.setRegion("Fictional");
            country.setSurfaceArea(200000.00);
            country.setIndependYear(2025);
            country.setPopulation(5000000);
            country.setLifeExpectancy(80.0);
            country.setGnp(100000.00);
            country.setLocalName("Imagina");
            country.setGovernmentForm("Republica");
            country.setHeadOfState("Jane Smith");
            country.setCapital(31);
            country.setCode2("IF");

            em.persist(country);

            // Datos de las ciudades
            List<City> cities = Arrays.asList(
                    new City(country, "Capital City", "Central District", 1500000),
                    new City(country, "Port Town", "Coastal District", 800000),
                    new City(country, "Mountain Village", "Highlands District", 200000)
            );

            for (City city : cities) {
                em.persist(city);
            }

            // Datos de los lenguajes
            List<CountryLanguage> languages = Arrays.asList(
                    new CountryLanguage(new CountryLanguageId("IMF", "Imaginary Language"), country, "T", 70.0),
                    new CountryLanguage(new CountryLanguageId("IMF", "Secondary Language"), country, "F", 30.0)
            );

            for (CountryLanguage language : languages) {
                em.persist(language);
            }

            // Commit de la transacción
            et.commit();
            System.out.println("Datos guardados exitosamente.");
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

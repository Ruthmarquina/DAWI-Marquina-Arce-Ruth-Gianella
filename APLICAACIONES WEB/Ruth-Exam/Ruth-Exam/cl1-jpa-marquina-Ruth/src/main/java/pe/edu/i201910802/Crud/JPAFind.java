package pe.edu.i201910802.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i201910802.Entity.City;
import pe.edu.i201910802.Entity.Country;

import java.util.List;
import java.util.stream.Collectors;

public class JPAFind {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");

        if (country != null) {
            List<City> cities = country.getCities().stream().filter(city -> city.getPopulation() > 700000).collect(Collectors.toList());

            System.out.println("Poblaciones peruanas con mas de 700mil");

            for (City c : cities) {
                System.out.println(c.getName());
            }
        } else {
            System.out.println("Pais no encontrado");
        }

        em.close();
        emf.close();
    }

}

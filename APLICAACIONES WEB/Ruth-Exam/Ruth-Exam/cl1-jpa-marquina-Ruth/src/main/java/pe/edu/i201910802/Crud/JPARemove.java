package pe.edu.i201910802.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i201910802.Entity.Country;

public class JPARemove {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Country country = em.find(Country.class, "IMF");

            if (country != null) {
                // Elimina la entidad
                em.remove(country);
            } else {
                System.out.println("El país con ID 'IMF' no existe.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

}

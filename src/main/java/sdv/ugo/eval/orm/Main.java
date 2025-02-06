package sdv.ugo.eval.orm;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("eval-orm");
        EntityManager em = emf.createEntityManager()) {


        }
    }
}
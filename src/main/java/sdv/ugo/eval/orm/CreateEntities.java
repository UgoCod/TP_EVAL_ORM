package sdv.ugo.eval.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import sdv.ugo.eval.orm.entities.*;

import java.time.LocalDate;
import java.util.List;

public class CreateEntities {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("eval-orm");
        EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            // Adresses
            Adresse adresseClisson = new Adresse("4", "Rue de la paix", "44190", "Clisson");
            Adresse adresseCugand = new Adresse("2", "Rue Vaugirard", "85610", "Cugand");
            Adresse adresseNantes = new Adresse("12", "Rue de l'ouest", "44000", "Nantes");

            // Chat
            Cat garfield = new Cat();
            garfield.setCouleur("Orange");
            garfield.setChipId("BNU123");
            garfield.setDateNaissance(LocalDate.of(2007, 5, 7));

            Cat mcGonagall = new Cat();
            mcGonagall.setCouleur("blue");
            garfield.setChipId("BFI765");
            mcGonagall.setDateNaissance(LocalDate.of(2007, 5, 7));

            // Poisson
            Fish nemo = new Fish();
            nemo.setCouleur("red");
            nemo.setDateNaissance(LocalDate.of(2003, 5, 7));
            nemo.setEnvironnement(FishLivEnv.SEA_WATER);

            Fish gardon = new Fish();
            gardon.setCouleur("gray");
            gardon.setDateNaissance(LocalDate.of(2024, 5, 7));
            gardon.setEnvironnement(FishLivEnv.FRESH_WATER);

            Fish brochet = new Fish();
            brochet.setCouleur("green");
            brochet.setDateNaissance(LocalDate.of(2024, 5, 7));
            brochet.setEnvironnement(FishLivEnv.FRESH_WATER);

            // Produits
            Produit prodOsPourChien = new Produit();
            prodOsPourChien.setLibelle("Os pour chien");
            prodOsPourChien.setPrix(15.00);
            prodOsPourChien.setType(ProdType.FOOD);
            prodOsPourChien.setCode("789012");

            Produit croquette = new Produit();
            croquette.setLibelle("Croquettes");
            croquette.setPrix(32.99);
            croquette.setType(ProdType.FOOD);
            croquette.setCode("789013");

            Produit balle = new Produit();
            balle.setLibelle("Balle");
            balle.setPrix(15.00);
            balle.setType(ProdType.ACCESSORY);
            balle.setCode("789014");

            // PetStore
            PetStore petStoreClisson = new PetStore();
            petStoreClisson.setAdresse(adresseClisson);
            petStoreClisson.setNom("Animalerie de Clisson");
            petStoreClisson.setNomManager("Quentin");

            petStoreClisson.ajouterProduit(prodOsPourChien);
            petStoreClisson.ajouterAnimal(garfield);
            petStoreClisson.ajouterAnimal(mcGonagall);
            petStoreClisson.ajouterAnimal(brochet);

            PetStore petStoreCugand = new PetStore();
            petStoreCugand.setAdresse(adresseCugand);
            petStoreCugand.setNom("Animalerie de Cugand");
            petStoreCugand.setNomManager("Bruno");

            petStoreCugand.ajouterProduit(croquette);
            petStoreCugand.ajouterAnimal(nemo);

            PetStore petStoreNantes = new PetStore();
            petStoreNantes.setAdresse(adresseNantes);
            petStoreNantes.setNom("Animalerie de Nantes");
            petStoreNantes.setNomManager("Seb");

            petStoreNantes.ajouterProduit(balle);
            petStoreNantes.ajouterAnimal(gardon);

            // Attribution des stores
            adresseCugand.setPetStore(petStoreCugand);
            adresseClisson.setPetStore(petStoreClisson);
            adresseNantes.setPetStore(petStoreNantes);

            // Persistence des données
            em.persist(petStoreClisson);
            em.persist(petStoreCugand);
            em.persist(petStoreNantes);

            em.getTransaction().commit();

            TypedQuery<Animal> query = em.createQuery(
                    "SELECT a FROM Animal a WHERE a.petStore = :petStore" , Animal.class);
            PetStore animauxDeClisson = petStoreClisson;
            List<Animal> animaux = query.setParameter("petStore", animauxDeClisson).getResultList();
            System.out.println("Animaux chez " + petStoreClisson.getNom() + " : " + animaux);
            // Il nous faudrait un attribut avec le nom de l'animal

        }
    }
}

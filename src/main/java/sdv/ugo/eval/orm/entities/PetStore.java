package sdv.ugo.eval.orm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "PetStore")
public class PetStore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50, nullable = false)
    private String nom;

    @Column(name = "managerName", length = 50, nullable = false)
    private String nomManager;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "storeProducts",
            joinColumns = @JoinColumn(name = "id_petStore", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    private Set<Produit> produits;
    {
        produits = new HashSet<>();
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animaux;
    {
        animaux = new HashSet<>();
    }

    public PetStore() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomManager() {
        return nomManager;
    }

    public void setNomManager(String nomManager) {
        this.nomManager = nomManager;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Set<Animal> animaux) {
        this.animaux = animaux;
    }
}

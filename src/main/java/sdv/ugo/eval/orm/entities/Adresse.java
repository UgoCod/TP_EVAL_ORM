package sdv.ugo.eval.orm.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "Address")
public class Adresse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number", length = 50, nullable = false)
    private String numero;

    @Column(name = "street", length = 50, nullable = false)
    private String rue;

    @Column(name = "zipCode", length = 5, nullable = false)
    private String codePostal;

    @Column(name = "city", length = 50, nullable = false)
    private String ville;

    @OneToOne(cascade = CascadeType.ALL)
    private PetStore petStore;

    public Adresse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}

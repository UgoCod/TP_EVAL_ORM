package sdv.ugo.eval.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "Fish")
public class Fish extends Animal {

    @Column(name = "livingEnv")
    private FishLivEnv environnement;

    public Fish() {
    }

    public FishLivEnv getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(FishLivEnv environnement) {
        this.environnement = environnement;
    }
}

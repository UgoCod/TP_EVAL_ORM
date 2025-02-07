package sdv.ugo.eval.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "Cat")
public class Cat extends Animal {

    @Column(name = "chipId", length = 10)
    private String chipId;

    public Cat() {
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }
}
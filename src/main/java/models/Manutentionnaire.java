package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MANUTENTIONNAIRE")
public class Manutentionnaire extends Employe {
    private int heuresTravail;
    
    public Manutentionnaire() {}

    public Manutentionnaire(int id,String nom, int age, String dateEntree, int heuresTravail) {
        super(id, nom, age, dateEntree);
        this.heuresTravail = heuresTravail;
    }
    public Manutentionnaire(String nom, int age, String dateEntree, int heuresTravail) {
        super(nom, age, dateEntree);
        this.heuresTravail = heuresTravail;
    }

    @Override
    public double calculerSalaire() {
        return heuresTravail * 65;
    }
}
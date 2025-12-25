package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRODUCTEUR")
public class Producteur extends Employe {
    private int unitesProduites;

    public Producteur() {}
    public Producteur(int id, String nom, int age, String dateEntree, int unitesProduites) {
        super(id, nom, age, dateEntree);
        this.unitesProduites = unitesProduites;
    }
    
    public Producteur(String nom, int age, String dateEntree, int unitesProduites) {
        super(nom, age, dateEntree);
        this.unitesProduites = unitesProduites;
    }

    @Override
    public double calculerSalaire() {
        return unitesProduites * 5;
    }
}
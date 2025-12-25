package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRODARISQUE")
public class ProdARisque extends Producteur  {

    public ProdARisque(int id, String nom, int age, String dateEntree, int unitesProduites) {
        super(id, nom, age, dateEntree, unitesProduites);
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + 200;
    }
}
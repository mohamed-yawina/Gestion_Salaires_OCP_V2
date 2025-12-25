package models;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MANUTARISQUE")
public class ManutARisque extends Manutentionnaire  {
	

    public ManutARisque(int id, String nom, int age, String dateEntree, int heuresTravail) {
        super(id, nom, age, dateEntree, heuresTravail);
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + 200;
    }
}
package models;
import javax.persistence.*;

@Entity
@DiscriminatorValue("COMMERCIAL")
public class Commercial extends Employe {
    protected double chiffreAffaire;
    protected double primeFixe;
    
    public Commercial() {};

    public Commercial(int id, String nom, int age, String dateEntree, double chiffreAffaire, double primeFixe) {
        super(id, nom, age, dateEntree);
        this.chiffreAffaire = chiffreAffaire;
        this.primeFixe = primeFixe;
    }

    @Override
    public double calculerSalaire() {
        return 0.2 * chiffreAffaire + primeFixe;
    }
}
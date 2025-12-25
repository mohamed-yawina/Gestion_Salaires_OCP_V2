package models; 

@DiscriminatorValue("VENDEUR")
public class Vendeur extends Employe {
	private double chiffreAffaire;
	public Vendeur() {}
	public Vendeur(String nom, int age, String dateEntree, double chiffreAffaire) { 11 super(nom, age, dateEntree);
	this.chiffreAffaire = chiffreAffaire;
	}

@Override
public double calculerSalaire() {
	return 0.2 * chiffreAffaire + 4000;
	}
}
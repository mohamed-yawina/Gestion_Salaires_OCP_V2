package models;
@Entity
@Table(name = "employe")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
name = "type_employe",
discriminatorType = DiscriminatorType.STRING
)
public abstract class Employe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
protected int id;
protected String nom;
protected int age;
@Column(name = "date_entree")
protected String dateEntree;
public Employe() {}
public Employe(String nom, int age, String dateEntree) {
this.nom = nom;
this.age = age;
this.dateEntree = dateEntree;
}
public abstract double calculerSalaire();
}

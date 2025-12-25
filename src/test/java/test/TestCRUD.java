package test;

public class TestCRUD {
	public static void main(String[] args) {
		EmployeDAO dao = new EmployeDAO();
		}
	Employe e1 = new Vendeur("Aicha", 30, "2020-05-10", 50000);
	dao.addEmploye(e1);
	
	System.out.println("Liste des employés :");
	List<Employe> list = dao.getAllEmployes();
	for (Employe e : list) {
		System.out.println(
				e.getId() + " | " +
				e.getNom() + " | " +
				e.getClass().getSimpleName() + " | " +
				e.calculerSalaire()
				);
		}

if (!list.isEmpty()) {
	Employe emp = list.get(0);
	emp.setNom("Ahmed");
	dao.updateEmploye(emp);
	System.out.println("Employé modifié : " + emp.getNom());
	}


if (!list.isEmpty()) {
	dao.deleteEmploye(list.get(0).getId());
	System.out.println("Employé supprimé.");
	}
HibernateUtil.getSessionFactory().close();
}
}

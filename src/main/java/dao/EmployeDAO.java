package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import models.Employe;
import util.HibernateUtil;

public class EmployeDAO {

  public void addEmploye(Employe e) {
       Session session = HibernateUtil.getSessionFactory().openSession(); 
       Transaction tx =  session.beginTransaction();
       session.persist(e);
       tx.commit();
       session.close();
      }


  public List<Employe> getAllEmployes() {
	Session session = HibernateUtil.getSessionFactory().openSession(); 
	List<Employe> list = session.createQuery("from Employe", Employe.class).list();
	session.close();
	return list;
	}


   public void updateEmploye(Employe e) {
	  Session session = HibernateUtil.getSessionFactory().openSession(); 
	  Transaction tx = session.beginTransaction();
	  session.merge(e);
	  tx.commit();
	  session.close();
	  }

  
   public void deleteEmploye(int id) {
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  Transaction tx = session.beginTransaction();
	  Employe e = session.get(Employe.class, id);
	  if (e != null) {
		  session.remove(e);
		  }
	  tx.commit();
	  session.close();
	  }	
   
   public void resetAutoIncrement() {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    session.createNativeQuery("ALTER TABLE employe AUTO_INCREMENT = 1")
	           .executeUpdate();

	    tx.commit();
	    session.close();
	}

   }
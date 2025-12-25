package test;

import org.hibernate.Session;
import util.HibernateUtil;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Hibernate fonctionne !");
        session.close();
    }
}

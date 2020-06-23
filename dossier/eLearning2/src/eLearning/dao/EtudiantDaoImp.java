package eLearning.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import eLearning.dao.Entity.Etudiant;

public class EtudiantDaoImp implements EtudiantDAO{
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Classe.class).buildSessionFactory();
	Session session = factory.getCurrentSession();
	
	
	public List<Etudiant> GetEtudiants()  throws Exception {
		session.beginTransaction();
		   return session.createQuery("SELECT a FROM Etudiant a", Etudiant.class).getResultList();      	
	}
	
	
}

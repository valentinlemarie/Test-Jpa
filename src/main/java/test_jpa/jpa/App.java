package test_jpa.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import objets.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	System.out.println("coonection base de donnée :"+entityManager.isOpen() ) ;
    	entityManager.getTransaction().begin();
    	
    	Livre livre = entityManager.find(Livre.class, 4);
    	if(livre != null){
    		System.out.println(livre);
    	}
    	
    	Query query = entityManager.createQuery("select l from Livre l where l.titre='Germinal' ");
    	Livre livre1 = (Livre)query.getResultList().get(0);
    	if(livre1 != null){
    		System.out.println(livre1);
    	}
    	
    	
    	query = entityManager.createQuery("select emp from Emprunt emp where emp.id=:ref");
    	query.setParameter("ref", 1);
    	Emprunt emprunt =(Emprunt)query.getResultList().get(0);
    	for (Livre livre2 : emprunt.getLivres()) {
			System.out.println(livre2);
		}
    	
    	
    	query = entityManager.createQuery("select client from Client client where client.id=:id_ref");
    	query.setParameter("id_ref", 1);
    	Client client = (Client)query.getResultList().get(0);
    	for (Emprunt emprunt2 : client.getEmprunts()) {
			System.out.println(emprunt2);
		}
    	
		
    	entityManager.close();
    	entityManagerFactory.close();
    }
}

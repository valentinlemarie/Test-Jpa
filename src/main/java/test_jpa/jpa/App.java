package test_jpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    		System.out.println(livre.toString());
    	}
    	
    	Query query = entityManager.createQuery("select l from Livre l where l.titre='Germinal' ");
    	Livre livre1 = (Livre)query.getResultList().get(0);
    	if(livre1 != null){
    		System.out.println(livre1.toString());
    	}
    	entityManager.close();
    	entityManagerFactory.close();
    }
}

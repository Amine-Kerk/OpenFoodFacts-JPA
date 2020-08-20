package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.offi.entity.Additif;

public class ConsoleJPA {

	public static void main(String[] args) throws Exception {
		
		EntityManagerFactory emf =null ;
		EntityManager em = null ; 
		
		try {
			emf = Persistence.createEntityManagerFactory("openfoodfacts");
			em =emf.createEntityManager();
			
			
			
			 Additif ad =  em.find(Additif.class, 5);
			System.out.println(ad);
			
			
			
			
			
			
			
		} finally {
			if (em !=null ) em.close();
			if (emf !=null ) emf.close();
			
			
		}

	}

}

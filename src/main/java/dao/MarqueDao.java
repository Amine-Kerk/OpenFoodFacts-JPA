package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Marque;

public class MarqueDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");
	EntityManager em = factory.createEntityManager();
	

	public void insertMarque(List<Marque> listMarques) {

		

	

		
		if (em != null) {

			
			for (Marque marques : listMarques) {
				
				em.getTransaction().begin();
			
				em.persist(marques);
			
				em.getTransaction().commit();
			}
			

			em.close();


		}


	}

}

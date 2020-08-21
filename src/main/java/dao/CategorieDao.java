package dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Categorie;


public class CategorieDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");
	EntityManager em = factory.createEntityManager();
	
	public void insertCategorie(EntityManager em, List<Categorie> listCategories) {

		
			for (Categorie categories : listCategories) {

		// On créer un canal de communication em en utilisant la factory
				// J'ouvre une transaction avec la BDD via mon EntityManager
				em.getTransaction().begin();

		
				// J'ajoute dans la base mon nouveau allergene
				em.persist(categories);

		// Si le canal de communication est différent de nul on peut ajouter
		if (em != null) {
			

		

			
			em.getTransaction().begin();
				em.getTransaction().commit();

		
			em.persist(categories);
			}

			// Je commite et je ferme la transaction, le cannal de communication et la
			// factory
			// On ferme la transaction, le cannal de communication

			em.getTransaction().commit();
			em.close();
			//factory.close();

		}

	}
}
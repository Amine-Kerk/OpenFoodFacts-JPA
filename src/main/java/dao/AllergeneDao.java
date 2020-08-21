package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Allergene;

public class AllergeneDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");
	EntityManager em = factory.createEntityManager();
	

		
	public void insertAllergene(EntityManager em, List<Allergene> listAllergenes) {

		// Si le canal de communication est différent de nul on peut ajouter 
		if (em != null) {
			/**
			 *
			 * On parcours la liste avec une boucle for On ajoute chaque éléments au fur et
			 * a mesure dans la BDD
			 * 
			 */
			for (Allergene allergenes : listAllergenes) {
				// J'ouvre une transaction avec la BDD via mon EntityManager
				em.getTransaction().begin();
				// J'ajoute dans la base mon nouveau allergene
				em.persist(allergenes);
				// On commite
				em.getTransaction().commit();
			}
			// On ferme la transaction, le cannal de communication
			em.close();
		}
	}
}
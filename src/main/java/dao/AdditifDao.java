package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Additif;


public class AdditifDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");
	EntityManager em = factory.createEntityManager();
	

	
	public void insertAdditif(EntityManager em, List<Additif>listAdditif) {

		// Si le canal de communication est différent de nul on peut ajouter un livre
		if (em != null) {
			/**
			 *
			 * On parcours la liste avec une boucle for On ajoute chaque éléments au fur et
			 * a mesure dans la BDD
			 * 
			 */
			for (Additif additifs : listAdditif) {
				// J'ouvre une transaction avec la BDD via mon EntityManager
				em.getTransaction().begin();
				// J'ajoute dans la base mon nouveau allergene
				em.persist(additifs);
				// On commite
				em.getTransaction().commit();
			}
			// On ferme la transaction, le cannal de communication
			em.close();
		}
	}
}

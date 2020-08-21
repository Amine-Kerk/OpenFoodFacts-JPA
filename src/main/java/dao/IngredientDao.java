package dao;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.Ingredient;

public class IngredientDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");
	EntityManager em = factory.createEntityManager();
	

		
	public void insertIngredient(EntityManager em, List<Ingredient> listIngredients) {

		// Si le canal de communication est différent de nul on peut ajouter
		if (em != null) {
			/**
			 *
			 * On parcours la liste avec une boucle for On ajoute chaque éléments au fur et
			 * a mesure dans la BDD
			 * 
			 */
			for (Ingredient ingredients : listIngredients) {
				// J'ouvre une transaction avec la BDD via mon EntityManager
				em.getTransaction().begin();
				// J'ajoute dans la base mon nouveau allergene
				em.persist(ingredients);
				// On commite
				em.getTransaction().commit();
			}
			// On ferme la transaction, le cannal de communication
			em.close();
		}
	}
}
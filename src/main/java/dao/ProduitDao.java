package dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Produit;

public class ProduitDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection");
	EntityManager em = factory.createEntityManager();
	

	public void insertProduit(EntityManager em, List<Produit> listproduits) {

		
		if (em != null) {

			
			for (Produit produits : listproduits) {

			
				em.getTransaction().begin();


				
				System.out.println(produits.getMarque().getNom());
				System.out.println(produits.getCategorie().getNom());
				em.persist(produits);

			em.getTransaction().begin();
				em.getTransaction().commit();

	
			em.persist(produits);
			}

		

			em.getTransaction().commit();
		
			em.close();

		}

	}
}

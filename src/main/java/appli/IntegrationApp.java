package appli;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.io.FileUtils;

import model.Additif;
import model.Allergene;
import model.Categorie;
import model.Ingredient;
import model.Marque;
import model.Produit;
import dao.AdditifDao;
import dao.AllergeneDao;
import dao.CategorieDao;
import dao.IngredientDao;
import dao.MarqueDao;
import dao.ProduitDao;
import utils.CnxBdd;
import utils.Convertisseur;
import utils.StringUtils;
import utils.SupDoublon;

public class IntegrationApp {

	public static void main(String[] args) {

		AllergeneDao daoAll = new AllergeneDao();
		AdditifDao   daoadd = new AdditifDao();
		IngredientDao daoing = new IngredientDao();
		CategorieDao daocat = new CategorieDao();
		MarqueDao daomar = new MarqueDao();
		
		ProduitDao daoprod = new ProduitDao();

		List<String> listAllergene = new ArrayList<String>();
		List<String> listAdditifs = new ArrayList<String>();
		List<String> listIngredient = new ArrayList<String>();
		List<String> listMarque = new ArrayList<String>();
		List<String> listCategorie = new ArrayList<String>();
		List<Produit> listProduit = new ArrayList<Produit>();

		try {
			File file = new File("E:\\Developpements\\Projets\\Donnees\\openFoodFacts.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			EntityManager em = CnxBdd.getConnection();

			lignes.remove(0);

			for (String ligne : lignes) {

				Produit produit = new Produit();
				Marque marque = new Marque();
				Categorie categorie = new Categorie();

				String[] morceaux = ligne.split("\\|", -1);

				categorie.setNom(morceaux[0]);
				marque.setNom(morceaux[1]);

				em.getTransaction().begin();
				TypedQuery<Marque> q = em.createQuery("SELECT m FROM Marques m WHERE m.nommarq = :nom", Marque.class);
				q.setParameter("nom", marque.getNom());
				if (q.getResultList().isEmpty() == true)
					em.merge(marque);

				TypedQuery<Categorie> q1 = em.createQuery("SELECT c FROM Categories c WHERE c.nomcat = :nom",Categorie.class);
				q1.setParameter("nom", categorie.getNom());
				if (q1.getResultList().isEmpty() == true)
					em.merge(categorie);

				em.getTransaction().commit();

				produit.setNomprod(morceaux[2]);
				produit.setMarque(marque);
				produit.setCategorie(categorie);

				produit.setGradenutri(morceaux[3]);

				produit.setEnergie(Convertisseur.toDouble(morceaux[5]));
				produit.setGraisse(Convertisseur.toDouble(morceaux[6]));
				produit.setSucre(Convertisseur.toDouble(morceaux[7]));
				produit.setProteines(Convertisseur.toDouble(morceaux[9]));
				produit.setFibres(Convertisseur.toDouble(morceaux[8]));
				produit.setSel(Convertisseur.toDouble(morceaux[10]));
				produit.setVitA(Convertisseur.toDouble(morceaux[11]));
				produit.setVitD(Convertisseur.toDouble(morceaux[12]));
				produit.setVitE(Convertisseur.toDouble(morceaux[13]));
				produit.setVitK(Convertisseur.toDouble(morceaux[14]));
				produit.setVitC(Convertisseur.toDouble(morceaux[15]));
				produit.setVitB1(Convertisseur.toDouble(morceaux[16]));
				produit.setVitB2(Convertisseur.toDouble(morceaux[17]));
				produit.setVitPP(Convertisseur.toDouble(morceaux[18]));
				produit.setVitB6(Convertisseur.toDouble(morceaux[19]));
				produit.setVitB9(Convertisseur.toDouble(morceaux[20]));
				produit.setVitB12(Convertisseur.toDouble(morceaux[21]));
				produit.setCalcium(Convertisseur.toDouble(morceaux[22]));
				produit.setMagnesium(Convertisseur.toDouble(morceaux[23]));
				produit.setIron(Convertisseur.toDouble(morceaux[24]));
				produit.setFer(Convertisseur.toDouble(morceaux[25]));
				produit.setBetacarotene(Convertisseur.toDouble(morceaux[26]));
				produit.setPresencehuiledepalme(morceaux[27]);

				listAdditifs.add(morceaux[28]);
				List<Additif> listSansDoublonAdditifs = SupDoublon.SupprimDoublonAdditifs(listAdditifs);
				for (Additif a : listSansDoublonAdditifs) {
					produit.getListadditif().add(a);
				}

				listAllergene.add(morceaux[29]);
				List<Allergene> listSansDoublon = SupDoublon.SupprimDoublonAllergnes(listAllergene);
				for (Allergene a : listSansDoublon) {
					produit.getListallergene().add(a);
				}

				listIngredient.add(morceaux[4]);
				List<Ingredient> listSansDoublonIngredient = SupDoublon.SupprimDoublonIngredients(listIngredient);
				for (Ingredient a : listSansDoublonIngredient) {
					produit.getListingredients().add(a);
				}


				em.getTransaction().begin();
				em.persist(produit);
				em.getTransaction().commit();

				listIngredient.clear();
				listAdditifs.clear();
				listAllergene.clear();

				String categories = morceaux[0];
				String marques = morceaux[1];
				String produit = morceaux[2];
				String gradenutri = morceaux[3];
				String ingredient = morceaux[4];

				double energie = Convertisseur.toDouble(morceaux[5]);
				double graisse = Convertisseur.toDouble(morceaux[6]);
				double sucre = Convertisseur.toDouble(morceaux[7]);
				double proteines = Convertisseur.toDouble(morceaux[9]);
				double fibres100g = Convertisseur.toDouble(morceaux[8]);
				double sel100g = Convertisseur.toDouble(morceaux[10]);
				double vitA100g = Convertisseur.toDouble(morceaux[11]);
				double vitD100g = Convertisseur.toDouble(morceaux[12]);
				double vitE100g = Convertisseur.toDouble(morceaux[13]);
				double vitK100g = Convertisseur.toDouble(morceaux[14]);
				double vitC100g = Convertisseur.toDouble(morceaux[15]);
				double vitB1100g = Convertisseur.toDouble(morceaux[16]);
				double vitB2100g = Convertisseur.toDouble(morceaux[17]);
				double vitPP100g = Convertisseur.toDouble(morceaux[18]);
				double vitB6100g = Convertisseur.toDouble(morceaux[19]);
				double vitB9100g = Convertisseur.toDouble(morceaux[20]);
				double vitB12100g = Convertisseur.toDouble(morceaux[21]);
				double calcium100g = Convertisseur.toDouble(morceaux[22]);
				double magnesium100g = Convertisseur.toDouble(morceaux[23]);
				double iron100g = Convertisseur.toDouble(morceaux[24]);
				double fer100g = Convertisseur.toDouble(morceaux[25]);
				double betaCarotene100g = Convertisseur.toDouble(morceaux[26]);
				double presenceHuilePalme = Convertisseur.toDouble(morceaux[27]);
				String Additif = morceaux[28];
				String Allergene = morceaux[29];

				// Additifs add = new Additifs ();
				// daoadd.insertAdditifs(add, Additif);

				// Ingredients ing = new Ingredients ();
				// daoing.insertIngredient(ing, ingredient);

				// Marques m = new Marques();
				// daomar.insertMarques(m, marques);

				// Categories c = new Categories();
				// daocat.insertCategories(c, categories);

				// Produit p = new Produit ();
				// daoprod.insertProduits(p, produit);

				listAllergene.add(Allergene);
				listAdditifs.add(Additif);
				listIngredient.add(ingredient);
				listMarque.add(marques);
			}

			// List<Allergenes> listSansDoublon =
			// SupDoublon.SupprimDoublonAllergnes(listAllergene);
			// daoAll.insertAllergene(listSansDoublon);

			//List<Additifs> listSansDoublonAdditifs = SupDoublon.SupprimDoublonAdditifs(listAdditifs);
			//daoadd.insertAdditif(listSansDoublonAdditifs);

			// List<Ingredients> listSansDoublonIngredient =
			// SupDoublon.SupprimDoublonIngredients(listIngredient);
			// daoing.insertIngredient(listSansDoublonIngredient);

			List<Marque> listSansDoublonMarques = SupDoublon.SupprimDoublonMarques(listMarque);
			daomar.insertMarque(listSansDoublonMarques);

			// System.out.println("Nombre de lignes :" + lignes.size());
			em.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}

	public IntegrationApp() {
		// TODO Auto-generated constructor stub
	}

}


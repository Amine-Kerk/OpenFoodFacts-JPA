package utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Additif;
import model.Allergene;
import model.Categorie;
import model.Ingredient;
import model.Marque;
import model.Produit;
public class SupDoublon {
	public static List<Allergene> SupprimDoublonAllergnes(List<String> listavecdoublon) {
		Set<String> mySet = new HashSet<String>();
		List<Allergene> listeAllergenes = new ArrayList<Allergene>();
		for (String ligneAllergeneParProduit : listavecdoublon) {
			String[] tableauDeMorceaux = ligneAllergeneParProduit.split(",", -1);
			for (int i = 0; i < tableauDeMorceaux.length; i++) {
				String all = tableauDeMorceaux[i];
				mySet.add(all);
			}
		}
		for (String nomAllergenes : mySet) {
			if (!nomAllergenes.isEmpty() || !nomAllergenes.isBlank()) {
				Allergene allergenes = new Allergene(nomAllergenes);
				listeAllergenes.add(allergenes);
			}
		}
		return listeAllergenes;
	}
	public static List<Ingredient> SupprimDoublonIngredients(List<String> listavecdoublon) {
		Set<String> mySet = new HashSet<String>();
		List<Ingredient> listeIngredients = new ArrayList<Ingredient>();
		for (String ligneIngredientsParProduit : listavecdoublon) {
			String[] tableauDeMorceaux = ligneIngredientsParProduit.split(",", -1);
			for (int i = 0; i < tableauDeMorceaux.length; i++) {
				String all = tableauDeMorceaux[i];
				mySet.add(all);
			}
		}
		for (String nomIngredients : mySet) {
			if (!nomIngredients.isEmpty() || !nomIngredients.isBlank()) {
				Ingredient ingredients = new Ingredient(nomIngredients);
				listeIngredients.add(ingredients);
			}
		}
		return listeIngredients;
	}
	public static List<Additif> SupprimDoublonAdditifs(List<String> listavecdoublon) {
		Set<String> mySet = new HashSet<String>();
		List<Additif> listeAdditifs = new ArrayList<Additif>();
		for (String ligneAdditifsParProduit : listavecdoublon) {
			String[] tableauDeMorceaux = ligneAdditifsParProduit.split(",", -1);
			for (int i = 0; i < tableauDeMorceaux.length; i++) {
				String all = tableauDeMorceaux[i];
				mySet.add(all);
			}
		}
		for (String nomAdditifs : mySet) {
			if (!nomAdditifs.isEmpty() || !nomAdditifs.isBlank()) {
				Additif additifs = new Additif(nomAdditifs);
				listeAdditifs.add(additifs);
			}
		}

		return listeAdditifs;
	}
	

	public static List<Marque> SupprimDoublonMarques(List<String> listavecdoublon) {

		Set<String> mySet = new HashSet<String>();
		List<Marque> listeAdditifs = new ArrayList<Marque>();

		for (int i = 0; i < listavecdoublon.size(); i++) {

			String all = listavecdoublon.get(i);

			mySet.add(all);
		}

		for (String nomMarque : mySet) {

			if (!nomMarque.isEmpty() || !nomMarque.isBlank()) {

				Marque marque = new Marque(nomMarque);

				listeAdditifs.add(marque);
			}

		}
			
		return listeAdditifs;
	}

	public static List<Categorie> SupprimDoublonCategories(List<String> listavecdoublon) {

		Set<String> mySet = new HashSet<String>();
		List<Categorie> listeAdditifs = new ArrayList<Categorie>();

		for (int i = 0; i < listavecdoublon.size(); i++) {

			String all = listavecdoublon.get(i);

			mySet.add(all);
		}

		for (String nomCategorie : mySet) {

			if (!nomCategorie.isEmpty() || !nomCategorie.isBlank()) {

				Categorie categorie = new Categorie(nomCategorie);

				listeAdditifs.add(categorie);
			}

		}

		return listeAdditifs;
	}

	public static List<Produit> SupprimDoublonProduits(List<String> listavecdoublon) {

		Set<String> mySet = new HashSet<String>();
		List<Produit> listeProduits = new ArrayList<Produit>();

		for (int i = 0; i < listavecdoublon.size(); i++) {

			String all = listavecdoublon.get(i);

			mySet.add(all);
		}

		for (String nomProduits : mySet) {

			if (!nomProduits.isEmpty() || !nomProduits.isBlank()) {

				Produit produit = new Produit(nomProduits);

				listeProduits.add(produit);
			}

		}

		return listeProduits;
	}

} 
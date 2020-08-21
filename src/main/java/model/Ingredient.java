package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredient")
public class Ingredient {
	// id ingredient auto-incrementé
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(name = "NOM", length = 4000, nullable = false, unique = true)
	private String nom;

	@OneToMany(mappedBy = "listingredients")
	private List<Produit> listproduit = new ArrayList<Produit>();

	// Constructeur sans argument de l'entity ingredients
	public Ingredient() {

	}

	public Ingredient(String nom) {
		super();
		this.nom = nom;
	}

	public int getId() {
		return ID;
	}
	public void setId(int ID) {
		this.ID = ID;
	}
	public String getNomingr() {
		return nom;
	}
	public void setNomingr(String nom) {
		this.nom = nom;
	}

	public List<Produit> getListproduit() {
		return listproduit;
	}

	public void setListproduit(List<Produit> listproduit) {
		this.listproduit = listproduit;
	}

	@Override
	public String toString() {
		return "Ingredients [ID=" + ID + ", nom=" + nom + "]";
	}
}

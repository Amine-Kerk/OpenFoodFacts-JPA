package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Categorie {
	// id categories auto-incrementé
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id_Categorie;

	@Column(name = "NOM", length = 250, nullable = false, unique = true)
	private String nomcat;

	@OneToMany (mappedBy="categorie")
	private List <Produit> listproduit;

	// Constructeur sans arguement de l'entity categories
	public Categorie() {

	}

	public Categorie(String nomcat) {
		super();
		this.nomcat = nomcat;
	}

	public int getId() {
		return id_Categorie;
	}
	public void setId(int id) {
		this.id_Categorie = id;
	}
	public String getNom() {
		return nomcat;
	}
	public void setNom(String nom) {
		this.nomcat = nom;
	}
	@Override
	public String toString() {
		return "Categories [id=" + id_Categorie + ", nom=" + nomcat + "]";
	}
}

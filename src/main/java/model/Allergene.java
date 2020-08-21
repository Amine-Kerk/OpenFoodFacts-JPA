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
@Table(name = "Allergene")
public class Allergene {

	// id allergenes auto-incrementé
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;

			@Column(name = "NOM", length = 100, nullable = false, unique = true)
			private String nom;

	

	@OneToMany(mappedBy = "listallergene")
	private List<Produit> listproduit = new ArrayList<Produit>();

	// Constructeur sans arguement de l'entity allergenes
	public Allergene() {


	}

	public Allergene(String nom) {
		super();
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomall() {
		return nom;
	}
	public void setNomall(String nomall) {
		this.nom = nomall;
	}
	@Override
	public String toString() {
		return "Allergenes [id=" + id + ", nomall=" + nom + "]";
	}


}

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
@Table(name = "Additif")
public class Additif {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(name = "NOM", length = 250, nullable = false, unique = true)
		private String nom;

	

	@OneToMany(mappedBy = "listadditif")
	private List<Produit> listproduit = new ArrayList<Produit>();

	
	public Additif() {
		

	}



	public Additif(String nom) {
		super();
		this.nom = nom;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomadd() {
		return nom;
	}
	public void setNomadd(String nomadd) {
		this.nom = nomadd;
	}
	@Override
	public String toString() {
		return "Additifs [id=" + id + ", nomadd=" + nom + "]";
	}
}
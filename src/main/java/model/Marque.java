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
@Table(name = "Marque")
public class Marque {
	// id marques auto-incrementé
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id_Marque;

	@Column(name = "NOM", length = 250, nullable = false, unique = true)
	private String nommarq;

	@OneToMany (mappedBy = "marque")
	private List <Produit> listprod;  

	// Constructeur sans argumeent de l'entity marques
	public Marque() {
		// TODO Auto-generated constructor stub
	}



	public Marque(String nommarq) {
		super();
		this.nommarq = nommarq;
	}



	public int getId() {
		
		return id_Marque;
	}

	public void setId(int id) {
		
		this.id_Marque = id;
	}

	public String getNom() {
		return nommarq;
	}
	public void setNom(String nom) {
		this.nommarq = nom;
	}

	@Override
	public String toString() {
		
		return "Marques [id=" + id_Marque+ ", nom=" + nommarq + "]";
	}

}
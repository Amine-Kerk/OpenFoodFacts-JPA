package fr.diginamic.offi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Représente une entité métier avec son identifiant et son nom
 * 
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Entite {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected String nom;

	
	public Entite(String nom) {
		super();
		this.nom = nom;
	}

	
	public Long getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public void setNom(String nom) {
		this.nom = nom;
	}
}

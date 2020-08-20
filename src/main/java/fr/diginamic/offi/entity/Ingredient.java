package fr.diginamic.offi.entity;

import javax.persistence.Entity;

@Entity
 
public class Ingredient extends Entite {

	
	public Ingredient(String nom) {
		super(nom);
	}
}

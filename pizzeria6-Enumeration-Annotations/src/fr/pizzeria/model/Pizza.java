package fr.pizzeria.model;

import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

public class Pizza {
	public static int compteurId = 0;
	public int id;
	
	@ToString(uppercase = true)
	public String code;
	@ToString(uppercase = true)
	public String libelle;
	@ToString
	public double prix;
	@ToString
	public CategoriePizza categorie;
	
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie) {
		this.id = ++compteurId;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public String toString() {
		//return "  " + code + " -> " + libelle + " (" + prix + " €) / " + categorie.toString();
		return StringUtils.returnStrSelonAnnotToString(this);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}
	
	
	
}

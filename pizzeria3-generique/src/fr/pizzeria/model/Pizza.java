package fr.pizzeria.model;

public class Pizza {
	public static int compteurId = 0;
	public int id;
	public String code;
	public String libelle;
	public double prix;
	
	public Pizza(String code, String libelle, double prix) {
		this.id = ++compteurId;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	
}

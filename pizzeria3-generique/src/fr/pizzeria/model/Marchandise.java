package fr.pizzeria.model;

public class Marchandise extends MarchandiseType {
	public static int compteurId = 0;
	public int id;
	public String code;
	public String nom;
	public double prix;
	public String[] valeurs;
	
	public Marchandise(String type, String code, String nom, double prix, String[] libelles, String[] valeurs) {
		super(type, libelles);
		this.id = ++compteurId;
		this.type = type;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.libelles = libelles;
		this.valeurs = valeurs;
	}
	
	public Marchandise(MarchandiseType mType, String code, String nom, double prix, String[] valeurs) {
		super(mType.type, mType.libelles);
		this.id = ++compteurId;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.valeurs = valeurs;
	}
	
	public String toString() {
		String m = "  " + type + " - "+ code + " -> " + nom + " (" + prix + " €) ";
		for(String valeur : valeurs) {
			m += valeur + ", ";
		}
		return m;
	}
	
	
}

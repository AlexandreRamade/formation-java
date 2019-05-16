package fr.ffc.model;

public class Feuille extends Arbre{
	private String valeur;
	
	
	
	public Feuille(Noeud parent, String name) {
		super(parent, name);
	}
	
	public Feuille(Noeud parent, String name, String valeur) {
		super(parent, name);
		this.valeur = valeur;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	
	
	
	
}

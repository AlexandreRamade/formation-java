package fr.ffc.model;

public abstract class Synthax {
	String ouverture;
	String fermeture;
	
	String champ;
	String valeur;
	
	String startTable;
	String endTable;
	
	String corespondance;
	String separator;
	
	int nbSousChamps;

	public String getOuverture() {
		return ouverture;
	}

	public String getFermeture() {
		return fermeture;
	}

	public String getChamp() {
		return champ;
	}

	public String getValeur() {
		return valeur;
	}

	public String getStartTable() {
		return startTable;
	}

	public String getEndTable() {
		return endTable;
	}

	public String getCorespondance() {
		return corespondance;
	}

	public String getSeparator() {
		return separator;
	}

	public int getNbSousChamps() {
		return nbSousChamps;
	}
	
	
	
	
}

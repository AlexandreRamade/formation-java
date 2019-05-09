package fr.ffc.model;

public class Champ {
	private String name = "";
	private int sousChampNb = 0;
	private String value = "";
	private boolean parent = false;
	
	public Champ(String name, int sousChampNb) {
		this.name = name;
		this.sousChampNb = sousChampNb;
		this.parent = true;
	}
	
	public Champ(String name, int sousChampNb, String value) {
		this.name = name;
		this.sousChampNb = sousChampNb;
		this.value = value;
	}
}

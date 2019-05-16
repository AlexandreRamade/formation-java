package fr.ffc.model;

public abstract class Arbre {
	private Noeud parent;
	private String name;
	
	
	public Arbre(Noeud parent) {
		super();
		this.parent = parent;
	}

	public Arbre(Noeud parent, String name) {
		super();
		this.parent = parent;
		this.name = name;
	}
	
	
	public Noeud getParent() {
		return parent;
	}
	public void setParent(Noeud parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	
}

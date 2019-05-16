package fr.ffc.model;

import java.util.LinkedList;

public class Noeud extends Arbre {
	private boolean typeBranche;
	private LinkedList<Arbre> enfants;
	
	
	
	
	public Noeud(Noeud parent) {
		super(parent);

	}

	public Noeud(Noeud parent, String name) {
		super(parent, name);
		
	}
	
	public Noeud(Noeud parent, LinkedList<Arbre> enfants) {
		super(parent);
		this.enfants = enfants;
		this.typeBranche = true;

	}

	public Noeud(Noeud parent, String name, LinkedList<Arbre> enfants) {
		super(parent, name);
		this.enfants = enfants;
	}
	
	
	
	
	
	public boolean isTypeBranche() {
		return typeBranche;
	}
	public void setTypeBranche(boolean typeBranche) {
		this.typeBranche = typeBranche;
	}
	public LinkedList<Arbre> getEnfants() {
		return enfants;
	}
	public void setEnfants(LinkedList<Arbre> enfants) {
		this.enfants = enfants;
	}
	
	
	
	
	
	
}

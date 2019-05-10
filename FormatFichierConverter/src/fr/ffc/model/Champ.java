package fr.ffc.model;

import java.util.LinkedList;

public class Champ {
	private int sousChampNb = 0;
	private String name = "";
	private LinkedList<String> names = new LinkedList<String>();
	private String value = "";
	private LinkedList<String> values = new LinkedList<String>();
	private boolean parent = false;
	private boolean table = false;
	
	public Champ(String name, int sousChampNb) {
		this.name = name;
		this.sousChampNb = sousChampNb;
		this.parent = true;
	}
	
	
	
	public Champ(int sousChampNb, LinkedList<String> names, LinkedList<String> values) {
		this.names = names;
		this.sousChampNb = sousChampNb;
		this.values = values;
		this.table = true;
	}



	public Champ(int sousChampNb, String name, String value) {
		this.name = name;
		this.sousChampNb = sousChampNb;
		if(value == null || value.equals("")) {
			this.parent = true;
		}else {
			this.value = value;
		}
	}
	
	public String toString() {
		String msg = sousChampNb + " ";
		if(name == null || name.equals("")) {
			msg += " [ ";
			for(int i = 0, lim = names.size(); i < lim; i++) {
				msg += names.get(i) + " = " + names.get(i) + ", ";
			}
			msg += " ] ";
		} else {
			msg = name + " = " + value;
		}
		return msg;
	}
}

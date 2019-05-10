package fr.fcc.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import fr.ffc.model.Arbre;
import fr.ffc.model.Champ;
import fr.ffc.model.Feuille;
import fr.ffc.model.FormatFichier;
import fr.ffc.model.Formats;
import fr.ffc.model.JsonSynthax;
import fr.ffc.model.Noeud;
import fr.ffc.model.Synthax;

public class LireFichier {
	
	static private Synthax synthax = new JsonSynthax();
	static private FormatFichier ff;
	static private LinkedList<Noeud> lastNoeudsParents = new LinkedList<Noeud>();
	static private LinkedList<Arbre> noeudsEnfants = new LinkedList<Arbre>();
	
	
	public static void lireAuFormat(FormatFichier formatFichier) {
		ff = formatFichier;
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(
					new FileReader(ff.getOrigin()));
			
			String line = "";
			int i = 0;
			while((line = reader.readLine()) != null) {
				champsFichier.add(lireChamp(line, i));
				i++;
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null) {
				reader = null;
			}
		}
		
		/*for(Champ champ : champsFichier) {
			System.out.println(champ.toString());
		}*/
		
	}
	
	private static void obtenirSynthax(Formats format) {
		
	}
	
	private static void lireChamp(String line, int ligne) {
		Noeud noeud = null;
		
		String name = "";
		String value = "";
				
		if(line.contains(synthax.getCorespondance())) {
			String[] champs = line.split(synthax.getCorespondance());
			
			name = champs[0];
			if(champs[1].contains(synthax.getOuverture())) {
				lastNoeudsParents.add(new Noeud(lastNoeudsParents.getLast(), name));
				return;
			}
			if(champs.length < 3) {
				if(champs[1].endsWith(synthax.getSeparator())) {
					value = champs[1].substring(0, champs[1].length() - 2);
					noeudsEnfants.add(new Feuille(lastNoeudsParents.getLast(), name, valeur));
					return;
				} else {
					value = champs[1];
					noeudsEnfants.add(new Feuille(lastNoeudsParents.getLast(), name, valeur));
					lastNoeudsParents.getLast().setEnfants(noeudsEnfants);
					noeudsEnfants = new LinkedList<Arbre>();
					lastNoeudsParents.removeLast();
					return;
				}
			} else { //dans un tableau : prendre en compte les [ et ]
				for(int i = 1, lim = champs.length; i < lim; i++) {
					if(i == champs.length - 1) {
						value = champs[i];
						noeudsEnfants.add(new Feuille(lastNoeudsParents.getLast(), name, value));
					} else {
						String[] valueName = champs[i].split(synthax.getSeparator());
						value = valueName[0];
						noeudsEnfants.add(new Feuille(lastNoeudsParents.getLast(), name, value));
						name = valueName[1];
					}
				}
				
				if(champs[i].endsWith(synthax.getSeparator())) {
					
				}
				
			}
			
			
		}
		
		
	
		if(line.contains(synthax.getSeparator())) {
			
			
			
			
			String[] demiLines = line.split(synthax.getSeparator());
			
			System.out.println("line contain separator");
			afficherTableau("demiLines", demiLines);
			
			
			
			for(String parametre : demiLines) {
				
				
				for(int i = 0; i < 2; i++) {
					nameValue[i] = parametre.substring(parametre.indexOf(synthax.getValeur(), parametre.lastIndexOf(synthax.getValeur())));
					
					if(i == 1 && parametre.contains(synthax.getStartTable())) {
						String[] valeurs = parametre.split(synthax.getSeparator());
						for(int j = 0, lim = valeurs.length; j < lim; j++) {
							if(j%2 == 0) {
								namesList.add(valeurs[i].substring(parametre.indexOf(synthax.getValeur(), parametre.lastIndexOf(synthax.getValeur()))));
							} else {
								valuesList.add(valeurs[i].substring(parametre.indexOf(synthax.getValeur(), parametre.lastIndexOf(synthax.getValeur()))));
							}
						}
					}
				}
			}
		}
		
		if(namesList.isEmpty()) {
			champ = new Champ(nbChamps, nameValue[0], nameValue[1]);
		} else {
			champ = new Champ(nbChamps, namesList, valuesList);
		}
		
		return noeud;
	}
	
	
	private static void afficherTableau(String name, String[] table) {
		
		System.err.println(name + " : " + table.length);
		for(String str : table) {
			System.err.println(str);
		}
		System.out.println("----------------------");
	}
	
	
}

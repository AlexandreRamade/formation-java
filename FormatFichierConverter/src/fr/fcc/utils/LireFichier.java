package fr.fcc.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import fr.ffc.model.Champ;
import fr.ffc.model.FormatFichier;
import fr.ffc.model.Formats;
import fr.ffc.model.JsonSynthax;
import fr.ffc.model.Synthax;

public class LireFichier {
	
	static private Synthax synthax = new JsonSynthax();
	static private FormatFichier ff;
	static private ArrayList<Champ> champsFichier = new ArrayList<Champ>();
	
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
	
	private static Champ lireChamp(String line, int ligne) {
		Champ champ = null;
		
		int nbChamps = 0;
		if(line.contains(synthax.getChamp())) {
			nbChamps = line.lastIndexOf(synthax.getChamp()) + 1;
			System.out.println("line " + ligne + " contain " + nbChamps + " champs");
		}
		
		String[] nameValue = new String[2];
		LinkedList<String> namesList = new LinkedList<String>();
		LinkedList<String> valuesList = new LinkedList<String>();
		
		
	
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
		
		return champ;
	}
	
	
	private static void afficherTableau(String name, String[] table) {
		
		System.err.println(name + " : " + table.length);
		for(String str : table) {
			System.err.println(str);
		}
		System.out.println("----------------------");
	}
	
	
}

package fr.fcc.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fr.ffc.model.FormatFichier;
import fr.ffc.model.Formats;
import fr.ffc.model.Synthax;

public class LireFichier {
	
	private Synthax synthax;
	
	public void lireAuFormat(FormatFichier ff) {
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(
					new FileReader(ff.getOrigin()));
			
			String line = "";
			while((line = reader.readLine()) != null) {
				
				//Analyse ligne par ligne ici
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
		
	}
	
	private void obtenirSynthax(Formats format) {
		
	}
	
}

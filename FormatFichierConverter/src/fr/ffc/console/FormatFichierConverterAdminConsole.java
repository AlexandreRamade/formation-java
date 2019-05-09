package fr.ffc.console;

import java.io.File;
import java.util.Scanner;

import fr.fcc.utils.SelectFichierUtil;
import fr.fcc.utils.SelectFormatUtil;
import fr.ffc.exception.CommandeFFCException;
import fr.ffc.exception.FormatException;
import fr.ffc.model.FormatFichier;
import fr.ffc.model.Formats;
import fr.ffc.services.AfficherHelp;

public class FormatFichierConverterAdminConsole {
	public static final String PREFIX_COMMANDE = "converter";
	
	public static void main(String[] args) {
		Scanner questionUser = new Scanner(System.in);
		
		String commandeUser = questionUser.nextLine().trim();
		
		String[] sousComUser = commandeUser.split("");
		
		FormatFichier ff = new FormatFichier();
		
		try {
			if(!sousComUser[0].equals(PREFIX_COMMANDE)) {
				throw new CommandeFFCException(sousComUser[0]);
			}
			
			if(commandeUser.matches("--help")) {
				new AfficherHelp().executeUserChoice();
			}
			
			if(sousComUser[1].matches("-o")) {
				if(!SelectFormatUtil.selectOutputFormat(ff, sousComUser[2], SelectFormatUtil.OUTPUT_FORMAT)) {
					throw new FormatException("Le format '" + sousComUser[2] + " n'est pas compatible.");
				}
			}
			
			if(SelectFichierUtil.selectFichierEtInputFormat(ff, sousComUser[sousComUser.length - 2])) {
				ff.setDestination(sousComUser[sousComUser.length - 1]);
				
				//appeler le traitement ici
			}
			
			
		} catch (CommandeFFCException e) {
			System.err.println(e.getMessage());
		} catch (FormatException e) {
			System.err.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		
		
		
	}
}

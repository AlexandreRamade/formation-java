package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.model.Marchandise;
import fr.pizzeria.model.MarchandiseType;
import fr.pizzeria.persistence.MarchandiseMemDao;

public class AjouterMarchandiseService extends MenuService {

	@Override
	public void executeUC(MarchandiseMemDao pmd, Scanner questionUser) {
		System.out.println("----- Ajout d'une nouvelle Marchandise");
		
		System.out.println("Indiquez le type :");
		questionUser.nextLine();			
		String typeNouvelleMarchandise = questionUser.nextLine();
		
		MarchandiseType mType;
		
		
		
		if(pmd.MarchandiseTypeExists(typeNouvelleMarchandise)) {
			//Afficher la liste des types possibles
		} else {
			System.err.println("Ce type de marchandise n'existe pas. Veuillez le creer avec le menu 5. avant de rentrer des marchandises.");
		}
		
		
		System.out.println("Veuillez saisir le code :");		
		String codeNouvelleMarchandise = questionUser.nextLine();
		
		if(pmd.MarchandiseExists(codeNouvelleMarchandise)) {
			System.err.println("ATENTION : Ce code de Marchandise existe déjà !");
		} else {
			System.out.println("Veuillez saisir le nom (sans espace) :");
			String nomNouvelleMarchandise = questionUser.nextLine();
			System.out.println("Veuillez saisir le prix :");
			Double prixNouvelleMarchandise = questionUser.nextDouble();
			
			
			
			MarchandiseType mType = pmd.findMarchandiseTypeByCode(codeNouvelleMarchandise);
			String[] valeursModifiees = new String[mType.libelles.length];
			if(valeursModifiees.length > 0) {
				for(int i = 0, lim = valeursModifiees.length; i < lim; i++) {
					System.out.println("Entrez le nouveau " + mType.libelles[i]);
					valeursModifiees[i] = questionUser.nextLine();
				}
			}
			
			Marchandise nouvelleMarchandise = new Marchandise(mType.type, codeNouvelleMarchandise, nomNouvelleMarchandise, prixNouvelleMarchandise, mType.libelles, valeursModifiees);
			pmd.saveNewMarchandise(nouvelleMarchandise);
		}
	}
	
}

package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.model.Marchandise;
import fr.pizzeria.model.MarchandiseType;
import fr.pizzeria.persistence.MarchandiseMemDao;

public class ModifierMarchandiseService extends MenuService{

	@Override
	public void executeUC(MarchandiseMemDao pmd, Scanner questionUser) {
		System.out.println("----- Mise à jour d'une Marchandise");
		System.out.println("Veuillez saisir le code de la Marchandise à modifier :");
		questionUser.nextLine();
		String codeMarchandiseAModifier = questionUser.nextLine();
		
		if(pmd.MarchandiseExists(codeMarchandiseAModifier)) {
			System.out.println("Veuillez saisir le nouveau code :");
			String codeModifMarchandise = questionUser.nextLine();
			
			if(pmd.MarchandiseExists(codeModifMarchandise)) {
				System.err.println("ATENTION : Ce code de Marchandise existe déjà !");
			} else {
				System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
				String nomModifMarchandise = questionUser.nextLine();
				System.out.println("Veuillez saisir le nouveau prix :");
				Double prixModifMarchandise = questionUser.nextDouble();
				
				questionUser.nextLine();
				MarchandiseType mType = pmd.findMarchandiseTypeByCode(codeMarchandiseAModifier);
				String[] valeursModifiees = new String[mType.libelles.length];
				if(valeursModifiees.length > 0) {
					for(int i = 0, lim = valeursModifiees.length; i < lim; i++) {
						System.out.println("Entrez le nouveau " + mType.libelles[i]);
						valeursModifiees[i] = questionUser.nextLine();
					}
				}
				
				Marchandise MarchandiseModifie = new Marchandise(mType.type, codeModifMarchandise, nomModifMarchandise, prixModifMarchandise, mType.libelles, valeursModifiees);
				pmd.updateMarchandise(codeMarchandiseAModifier, MarchandiseModifie);
			}
		} else {
			System.err.println("Code Marchandise invalide !");
		}
		
	}

}

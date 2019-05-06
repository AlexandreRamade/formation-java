package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.persistence.MarchandiseMemDao;

public class SupprimerMarchandiseService extends MenuService {

	@Override
	public void executeUC(MarchandiseMemDao pmd, Scanner questionUser) {
		System.out.println("----- Suppression d'une Marchandise");
		
		new ListerMarchandisesService().executeUC(pmd, questionUser);
		
		System.out.println("Veuillez saisir le code de la Marchandise à supprimer :");
		questionUser.nextLine();
		
		String codeMarchandiseASupprimer = questionUser.nextLine();
		if(pmd.MarchandiseExists(codeMarchandiseASupprimer)) {
			pmd.deleteMarchandise(codeMarchandiseASupprimer);
		} else {
			System.err.println("Code Marchandise invalide !");
		}
		
	}

}

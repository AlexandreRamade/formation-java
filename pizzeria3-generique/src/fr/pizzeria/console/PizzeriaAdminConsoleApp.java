package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.MarchandiseType;
import fr.pizzeria.persistence.MarchandiseMemDao;
import fr.pizzeria.services.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner questionUser = new Scanner(System.in);
		int optionUser = 0;
		
		//----------Marchandises initialement présentes
		
		
		//Initialisation du Dao
		MarchandiseMemDao pmd = new MarchandiseMemDao();
						
		do {
		//Menu principal
		System.out.println("\n***** Marchandises Administration *****");
		System.out.println("  1. Lister les marchandises");
		System.out.println("  2. Ajouter une nouvelle marchandise");
		System.out.println("  3. Mettre à jour une marchandise");
		System.out.println("  4. Supprimer une marchandise");
		System.out.println("  5. Créer un nouveau type de marchandise");
		System.out.println("  99. Sortir");
		
		System.out.println("\nFaites votre choix :");
		//récupération du choix de l'utilisateur
		optionUser = questionUser.nextInt();
		
		if(0 < optionUser && optionUser < 6) {
			MenuServiceFactory.obtenirMenuService(optionUser).executeUC(pmd, questionUser);
		} else if(optionUser == 99) {
			System.out.println("Au revoir !");
		} else {
			System.out.println("Je ne comprends pas...");
		}
		
		} while (optionUser != 99);

	}

}

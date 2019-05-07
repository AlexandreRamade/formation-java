package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Marchandise;
import fr.pizzeria.model.MarchandiseType;
import fr.pizzeria.persistence.MarchandiseMemDao;
import fr.pizzeria.services.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner questionUser = new Scanner(System.in);
		int optionUser = 0;
		
		//----------Marchandises initialement présentes
		MarchandiseType[] mTypes = new MarchandiseType[1];
		MarchandiseType pizzaType = new MarchandiseType("Pizza", new String[0]);
		mTypes[0] = pizzaType;
		
		Marchandise[] marchandises = new Marchandise[8];
		marchandises[0] = new Marchandise(pizzaType, "PEP", "Pépéroni", 12.50D, new String[0]);
		marchandises[1] = new Marchandise(pizzaType,"MAR", "Margharita", 14.00D, new String[0]);
		marchandises[2] = new Marchandise(pizzaType,"REIN", "La Reine", 11.50D, new String[0]);
		marchandises[3] = new Marchandise(pizzaType,"FRO", "La 4 fromages", 12.00D, new String[0]);
		marchandises[4] = new Marchandise(pizzaType,"CAN", "La cannibale", 12.50D, new String[0]);
		marchandises[5] = new Marchandise(pizzaType,"SAV", "La savoyarde", 13.00D, new String[0]);
		marchandises[6] = new Marchandise(pizzaType,"ORI", "L'orientale", 13.50D, new String[0]);
		marchandises[7] = new Marchandise(pizzaType,"IND", "L'indienne", 14.00D, new String[0]);
		
		
		//Initialisation du Dao
		MarchandiseMemDao pmd = new MarchandiseMemDao(mTypes, marchandises);
		
		
		
		do {
		//Menu principal
		System.out.println("\n***** Marchandises Administration *****");
		System.out.println("  1. Lister les marchandises");
		System.out.println("  2. Ajouter une nouvelle marchandise");
		System.out.println("  3. Mettre à jour une marchandise");
		System.out.println("  4. Supprimer une marchandise");
		System.out.println("  5. Lister les types de marchandises existants");
		System.out.println("  6. Créer un nouveau type de marchandise");
		System.out.println("  99. Sortir");
		
		System.out.println("\nFaites votre choix :");
		//récupération du choix de l'utilisateur
		optionUser = questionUser.nextInt();
		
		if(0 < optionUser && optionUser < 7) {
			MenuServiceFactory.obtenirMenuService(optionUser).executeUC(pmd, questionUser);
		} else if(optionUser == 99) {
			System.out.println("Au revoir !");
		} else {
			System.out.println("Je ne comprends pas...");
		}
		
		} while (optionUser != 99);

	}

}

package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.persistence.PizzaMemDao;
import fr.pizzeria.services.AjouterPizzaService;
import fr.pizzeria.services.ListerPizzasService;
import fr.pizzeria.services.MenuServiceFactory;
import fr.pizzeria.services.ModifierPizzaService;
import fr.pizzeria.services.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner questionUser = new Scanner(System.in);
		int optionUser = 0;
		
		//----------pizzas initialement présentes
		Pizza[] pizzas = new Pizza[8];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50D);
		pizzas[1] = new Pizza("MAR", "Margharita", 14.00D);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50D);
		pizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00D);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50D);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00D);
		pizzas[6] = new Pizza("ORI", "L'orientale", 13.50D);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00D);
		
		//Initialisation du Dao
		PizzaMemDao pmd = new PizzaMemDao(pizzas);
		
		
		do {
		//Menu principal
		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("  1. Lister les pizzas");
		System.out.println("  2. Ajouter une nouvelle pizza");
		System.out.println("  3. Mettre à jour une pizza");
		System.out.println("  4. Supprimer une pizza");
		System.out.println("  99. Sortir");
		
		System.out.println("\nFaites votre choix :");
		//récupération du choix de l'utilisateur
		optionUser = questionUser.nextInt();
		
		if(0 < optionUser && optionUser < 5) {
			MenuServiceFactory.obtenirMenuService(optionUser).executeUC(pmd, questionUser);
		} else if(optionUser == 99) {
			System.out.println("Au revoir !");
		} else {
			System.out.println("Je ne comprends pas...");
		}
		
		} while (optionUser != 99);

	}

}

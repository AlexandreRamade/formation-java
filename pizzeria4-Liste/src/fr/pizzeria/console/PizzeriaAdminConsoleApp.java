package fr.pizzeria.console;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.persistence.PizzaMemDao;
import fr.pizzeria.services.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner questionUser = new Scanner(System.in);
		int optionUser = 0;
		
		//----------pizzas initialement pr�sentes
		List<Pizza> pizzas = new LinkedList<Pizza>();
		pizzas.add(new Pizza("PEP", "P�p�roni", 12.50D));
		pizzas.add(new Pizza("MAR", "Margharita", 14.00D));
		pizzas.add(new Pizza("REIN", "La Reine", 11.50D));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00D));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50D));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00D));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50D));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00D));
		
		//Initialisation du Dao
		PizzaMemDao pmd = new PizzaMemDao(pizzas);
		
		
		do {
		//Menu principal
		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("  1. Lister les pizzas");
		System.out.println("  2. Ajouter une nouvelle pizza");
		System.out.println("  3. Mettre � jour une pizza");
		System.out.println("  4. Supprimer une pizza");
		System.out.println("  99. Sortir");
		
		System.out.println("\nFaites votre choix :");
		//r�cup�ration du choix de l'utilisateur
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

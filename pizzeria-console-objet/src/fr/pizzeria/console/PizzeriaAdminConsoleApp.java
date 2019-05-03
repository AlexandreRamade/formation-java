package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner questionUser = new Scanner(System.in);
		int optionUser = 0;
		
		
		do {
		
		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("  1. Lister les pizzas");
		System.out.println("  2. Ajouter une nouvelle pizza");
		System.out.println("  3. Mettre à jour une pizza");
		System.out.println("  4. Supprimer une pizza");
		System.out.println("  99. Sortir");
		
		System.out.println("\nFaites votre choix :");
		optionUser = questionUser.nextInt();
		
		switch (optionUser) {
		case 1 :
			System.out.println("Liste des pizzas :");
			break;
		case 2 :
			System.out.println("Ajout d'une nouvelle pizza");
			break;
		case 3 :
			System.out.println("Mise à jour d'une pizza");
			break;
		case 4 :
			System.out.println("Suppression d'une pizza");
			break;
		default :
			System.out.println("Au revoir !");
		}
		
		
		} while (optionUser != 99);

	}

}

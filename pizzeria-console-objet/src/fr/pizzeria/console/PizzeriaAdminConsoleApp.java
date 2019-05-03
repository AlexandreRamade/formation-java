package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner questionUser = new Scanner(System.in);
		int optionUser = 0;
		
		Pizza[] pizzas = new Pizza[8];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50D);
		pizzas[1] = new Pizza("MAR", "Margharita", 14.00D);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50D);
		pizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00D);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50D);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00D);
		pizzas[6] = new Pizza("ORI", "L'orientale", 13.50D);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00D);
		
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
			for(int i = 0, limite = pizzas.length; i < limite; i++) {
				System.out.println("  " + pizzas[i].code + " -> " + pizzas[i].libelle + " (" + pizzas[i].prix + " €)");
			}
			break;
		case 2 :
			System.out.println("----- Ajout d'une nouvelle pizza");
			System.out.println("Veuillez saisir le code :");
			questionUser.nextLine();
			
			String codeNouvellePizza = questionUser.nextLine();
			System.out.println("Veuillez saisir le nom (sans espace) :");
			String nomNouvellePizza = questionUser.nextLine();
			System.out.println("Veuillez saisir le prix :");
			Double prixNouvellePizza = questionUser.nextDouble();
			
			Pizza[] pizzas2 = new Pizza[pizzas.length + 1];
			for(int i = 0, limite = pizzas.length; i < limite; i++) {
				pizzas2[i] = pizzas[i];
			}
			pizzas2[pizzas.length] = new Pizza(codeNouvellePizza, nomNouvellePizza, prixNouvellePizza);
			pizzas = pizzas2;
			
			break;
		case 3 :
			System.out.println("----- Mise à jour d'une pizza");
			System.out.println("Veuillez saisir le code de la pizza à modifier :");
			questionUser.nextLine();
			
			String codePizzaAModifier = questionUser.nextLine();
			
			System.out.println("Veuillez saisir le nouveau code :");
			String codeModifPizza = questionUser.nextLine();
			System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
			String nomModifPizza = questionUser.nextLine();
			System.out.println("Veuillez saisir le nouveau prix :");
			Double prixModifPizza = questionUser.nextDouble();
			
			for(int i = 0, limite = pizzas.length; i < limite; i++) {
				if(pizzas[i].code.equals(codePizzaAModifier)) {
					pizzas[i].code = codeModifPizza;
					pizzas[i].libelle = nomModifPizza;
					pizzas[i].prix = prixModifPizza;
					break;
				}
			}
			break;
		case 4 :
			System.out.println("----- Suppression d'une pizza");
			for(int i = 0, limite = pizzas.length; i < limite; i++) {
				System.out.println("  " + pizzas[i].code + " -> " + pizzas[i].libelle + " (" + pizzas[i].prix + " €)");
			}
			
			System.out.println("Veuillez saisir le code de la pizza à supprimer :");
			questionUser.nextLine();
			
			String codePizzaASupprimer = questionUser.nextLine();
			Pizza[] pizzas3 = new Pizza[pizzas.length - 1];
			for(int i = 0, j = 0, limite = pizzas.length; i < limite; i++) {
				if(!pizzas[i].code.equals(codePizzaASupprimer)) {
					pizzas3[j] = pizzas[i];
					j++;
				}
			}
			pizzas = pizzas3;
			
			break;
		default :
			System.out.println("Au revoir !");
		}
		
		
		} while (optionUser != 99);

	}

}

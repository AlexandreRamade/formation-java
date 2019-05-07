package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.persistence.PizzaMemDao;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pmd, Scanner questionUser) {
		System.out.println("----- Suppression d'une pizza");
		
		new ListerPizzasService().executeUC(pmd, questionUser);
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer :");
		questionUser.nextLine();
		
		String codePizzaASupprimer = questionUser.nextLine();
		if(pmd.pizzaExists(codePizzaASupprimer)) {
			pmd.deletePizza(codePizzaASupprimer);
		} else {
			System.err.println("Code pizza invalide !");
		}
		
	}

}

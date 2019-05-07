package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.persistence.PizzaMemDao;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pmd, Scanner questionUser) {
		System.out.println("----- Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		questionUser.nextLine();			
		String codeNouvellePizza = questionUser.nextLine();
		
		if(pmd.pizzaExists(codeNouvellePizza)) {
			System.err.println("ATENTION : Ce code de pizza existe déjà !");
		} else {
			System.out.println("Veuillez saisir le nom (sans espace) :");
			String nomNouvellePizza = questionUser.nextLine();
			System.out.println("Veuillez saisir le prix :");
			Double prixNouvellePizza = questionUser.nextDouble();
			
			Pizza nouvellePizza = new Pizza(codeNouvellePizza, nomNouvellePizza, prixNouvellePizza);
			pmd.saveNewPizza(nouvellePizza);
		}
	}
	
}

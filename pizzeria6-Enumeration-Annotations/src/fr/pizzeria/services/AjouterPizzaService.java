package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.persistence.PizzaMemDao;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(PizzaMemDao pmd, Scanner questionUser) throws PizzaException {
		System.out.println("----- Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		questionUser.nextLine();			
		String codeNouvellePizza = questionUser.nextLine();
		
		if(pmd.pizzaExists(codeNouvellePizza)) {
			throw new SavePizzaException("Le code de pizza existe d�j� !");
		} else {
			System.out.println("Veuillez saisir le nom (sans espace) :");
			String nomNouvellePizza = questionUser.nextLine();
			System.out.println("Veuillez saisir le prix :");
			Double prixNouvellePizza = questionUser.nextDouble();
			
			CategoriePizza categorie = new ListerChoixCategoriePizzaService().listerChoixCategoriePizza(questionUser);
			
			Pizza nouvellePizza = new Pizza(codeNouvellePizza, nomNouvellePizza, prixNouvellePizza, categorie);
			pmd.saveNewPizza(nouvellePizza);
		}
	}
	
}

package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.exception.CategorieNumberException;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;

public class ListerChoixCategoriePizzaService {
	
	public CategoriePizza listerChoixCategoriePizza(Scanner questionUser) throws PizzaException {
		boolean choixCategorieInvalide = true;
		int indexCategChoixUser = -1;
		CategoriePizza[] categories = CategoriePizza.values();
		while(choixCategorieInvalide){
			try {
			System.out.println("Veuillez choisir la cat�gorie :");
			int indexCateg = 0;
			for(CategoriePizza categ : categories) {
				System.out.println(indexCateg + ". " + categ.toString());
				indexCateg++;
			}
			indexCategChoixUser = questionUser.nextInt();
				if(indexCategChoixUser <= indexCateg) {
					choixCategorieInvalide = false;
				} else {
					throw new CategorieNumberException("La valeur indiqu�e ne corespond � aucune cat�gorie de pizza.");
				}
			} catch (CategorieNumberException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return categories[indexCategChoixUser];
	}
}

package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.persistence.PizzaMemDao;

public abstract class MenuService {
	public abstract void executeUC(PizzaMemDao pmd, Scanner questionUser) throws PizzaException;
}

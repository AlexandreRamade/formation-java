package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.persistence.MarchandiseMemDao;

public abstract class MenuService {
	public abstract void executeUC(MarchandiseMemDao pmd, Scanner questionUser);
}

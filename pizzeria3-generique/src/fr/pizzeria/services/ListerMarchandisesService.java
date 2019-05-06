package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.model.Marchandise;
import fr.pizzeria.persistence.MarchandiseMemDao;

public class ListerMarchandisesService extends MenuService {

	@Override
	public void executeUC(MarchandiseMemDao pmd, Scanner questionUser) {
		System.out.println("Liste des Marchandises :");
		for(Marchandise marchandise : pmd.findAllMarchandises()) {
			System.out.println(marchandise.toString());
		}
	}


}

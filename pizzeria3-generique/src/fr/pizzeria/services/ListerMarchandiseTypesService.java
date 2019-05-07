package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.model.Marchandise;
import fr.pizzeria.model.MarchandiseType;
import fr.pizzeria.persistence.MarchandiseMemDao;

public class ListerMarchandiseTypesService extends MenuService {

	@Override
	public void executeUC(MarchandiseMemDao pmd, Scanner questionUser) {
		System.out.println("Liste des types de marchandises :");
		for(MarchandiseType mType : pmd.findAllMarchandiseTypes()) {
			System.out.println(mType.toString());
		}
	}


}

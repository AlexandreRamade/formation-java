package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.model.MarchandiseType;
import fr.pizzeria.persistence.MarchandiseMemDao;

public class AjouterMarchandiseTypeService extends MenuService {

	@Override
	public void executeUC(MarchandiseMemDao pmd, Scanner questionUser) {
		System.out.println("Entrez le type de marchandise que vous souhaitez lister (sans espace) :");
		String typeMarchandise = questionUser.nextLine();
		System.out.println("En plus des libellés 'code', 'nom' et 'prix', indiquez les informations que vous souhaitez y associer :");
		System.err.println("Entrez 'stop' lorsque vous avez terminé.");
		String libelle = "";
		String[] libelles = new String[0];
		while(!libelle.toLowerCase().equals("stop")) {
			libelle = questionUser.nextLine();
			if (libelle.toLowerCase().equals("stop")) {
				String[] libelles2 = new String[libelles.length + 1];
				for(int i = 0, lim = libelles.length; i < lim; i++) {
					libelles2[i] = libelles[i];
				}
				libelles = libelles2;
			}
		}
		
		MarchandiseType mType = new MarchandiseType(typeMarchandise, libelles);
		if(pmd.MarchandiseTypeExists(mType)) {
			System.err.println("Ce type de marchandise existe déjà !");
		} else {
			pmd.saveNewMarchandiseType(mType);
		}
		
	}

}

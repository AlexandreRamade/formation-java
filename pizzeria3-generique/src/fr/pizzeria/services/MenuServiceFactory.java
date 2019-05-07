package fr.pizzeria.services;

public class MenuServiceFactory {
	
	public static MenuService obtenirMenuService(int choixMenuUtilisateur) {
		switch (choixMenuUtilisateur) {
		case 1 :
			return new ListerMarchandisesService();
		case 2 :
			return new AjouterMarchandiseService();		
		case 3 :
			return new ModifierMarchandiseService();
		case 4 :
			return new SupprimerMarchandiseService();
		case 5 :
			return new ListerMarchandiseTypesService();
		case 6 :
			return new AjouterMarchandiseTypeService();
		default :
			return null;
		}
	}
	
}

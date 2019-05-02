package fr.tableaux;

public class TestArray2 {

	public static void main(String[] args) {
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		
		//--------------Calcul de la moyenne
		System.out.println("La moyenne des valeurs du tableau est :");
		int somme = 0;
		for(int i = 0, limite = array.length; i < limite; i++) {
			somme += array[i];
		}
		float moyenne = 0;
		moyenne = (float) somme / array.length;

		System.out.print(moyenne);
		
		
		//-------------Recherche de l'index de l'entier 15
		System.out.println("\n\nLe/les index de l'entier 15 est/sont :");
		for(int i = 0, limite = array.length; i < limite; i++) {
			if(array[i] == 15) {
				System.out.print(i + " ");
			}
		}
		
		//------------Algorythme pour trouver le nombre de doublon dans le tableau
		int nombreDeDoublon = 0;
		for(int currentIndex = 0, limite = array.length; currentIndex < limite; currentIndex++) {
			for(int i = currentIndex; i < limite; i++) {
				if(i != currentIndex && array[currentIndex] == array[i]) {
					nombreDeDoublon++;
				}
			}
		}
		System.out.println("\n\nLe tableau contient " + nombreDeDoublon + " doublons");
		
		
		
		
		
		
		
		
	}

}

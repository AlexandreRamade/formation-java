package fr.tableaux;

public class TestArray1 {

	public static void main(String[] args) {
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		
		System.out.println("Le tableau contient les valeurs :");
		for(int i = 0, limite = array.length; i < limite; i++) {
			System.out.print(array[i] + " ");
		}

		
		System.out.println("\n\nLe tableau lu en sens inverse contient les valeurs :");
		for(int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println("\n\nListe des entiers supérieurs ou égaux à 3 :");
		for(int i = 0, limite = array.length; i < limite; i++) {
			if(array[i] >= 3) {
				System.out.print(array[i] + " ");
			}
		}
		
		System.out.println("\n\nListe des entiers pairs :");
		for(int i = 0, limite = array.length; i < limite; i++) {
			if(array[i] % 2 == 0) {
				System.out.print(array[i] + " ");
			}
		}
		
		//Recherche des valeurs minimales et maximales
		int valeurMax = array[0];
		int valeurMin = array[0];
		for(int i = 1, limite = array.length; i < limite; i++) {
			if(array[i] > valeurMax) {
				valeurMax = array[i];
			}
			if(array[i] < valeurMin) {
				valeurMin = array[i];
			}
		}
		System.out.println("\n\nLa valeur maximale est :");
		System.out.print(valeurMax);
		
		System.out.println("\n\nLa valeur minimale est :");
		System.out.print(valeurMin);
		
	}

}

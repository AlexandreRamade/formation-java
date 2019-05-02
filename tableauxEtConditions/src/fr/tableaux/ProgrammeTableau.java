package fr.tableaux;

import java.util.Scanner;

public class ProgrammeTableau {
	
	public static void main(String[] args) {
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		
		int optionUser = -1;
		Scanner questionUser = new Scanner(System.in);
		
		do {
			System.out.println("\nQue voulez-vous faire ?");
			System.out.println("  1 = Ajouter un nombre");
			System.out.println("  2 = Afficher les nombres existants");
			System.out.println("  0 = Quitter");
			
			optionUser = questionUser.nextInt();
			
			
			switch (optionUser) {
			case 1 :
				System.out.println("\nEntrez la valeur :");
				int nouvelleValeur = questionUser.nextInt();
				int[] array2 = new int[array.length + 1];
				int i = 0;
				for(int limite = array.length; i < limite; i++) {
					array2[i] = array[i];
				}
				array2[i] = nouvelleValeur;
				array = array2;
				
				break;
			case 2 :
				System.out.println("\nLe tableau contient les valeurs :");
				for(int j = 0, limite = array.length; j < limite; j++) {
					System.out.print(array[j] + " ");
				}
				System.out.println("");
				break;
			default :
				System.out.println("\nSalut !");
				optionUser = -1;
			}
			
		} while (optionUser > 0);

	}
	
	

}

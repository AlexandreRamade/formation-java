package fr.tableaux;

import java.util.Scanner;

public class TestFibonacci {
	
	//ATTENTION : valable seulement jusqu'au rang 92 à cause de la limitation des nombres long
	
	public static void main(String[] args) {
		System.out.println("*****   Suite de Fibonacci   *****");
		System.out.println("\nEntrez le rang N du nombre que vous souhaitez connaitre dans la suite :");
		Scanner questionUser = new Scanner(System.in);
		int rangN = questionUser.nextInt();
		
		long valeurNmoins1 = 1L;
		long valeurN = 1L;
		
		if(rangN == 0) {
			valeurN = 0;
		}else if (rangN >= 3) {
			for(int i = 3; i <= rangN; i++) {
				valeurN += valeurNmoins1;
				valeurNmoins1 = valeurN - valeurNmoins1;
			}
		}		
		System.out.println("Dans la suite de Fibonacci, le nombre de rang " + rangN + " vaut : " + valeurN);
		System.out.println("Le quotient N/N-1 vaut : " + (float) valeurN/valeurNmoins1);
	}

}

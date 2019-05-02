package fr.tableaux;

import java.util.Scanner;

public class TestFibonacci {

	public static void main(String[] args) {
		System.out.println("*****   Suite de Fibonacci   *****");
		System.out.println("\nEntrez le rang N du nombre que vous souhaitez connaitre dans la suite :");
		Scanner questionUser = new Scanner(System.in);
		int rangN = questionUser.nextInt();
		
		int valeurNmoins1 = 1;
		int valeurN = 1;
		
		if(rangN == 0) {
			valeurN = 0;
		}else if (rangN >= 3) {
			for(int i = 3; i <= rangN; i++) {
				valeurN += valeurNmoins1;
				valeurNmoins1 = valeurN - valeurNmoins1;
			}
		}		
		System.out.print("Dans la suite de fibonacci, le nombre de rang " + rangN + " vaut : " + valeurN);
	}

}

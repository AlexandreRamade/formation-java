package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		System.out.println("***** Application Opérateurs *****");
		
		System.out.println("Veuillez saisir le premier nombre...");
		Scanner questionUser = new Scanner(System.in);
		int a = questionUser.nextInt();
		
		System.out.println("Veuillez saisir le second nombre...");
		questionUser = new Scanner(System.in);
		int b = questionUser.nextInt();
		
		System.out.println(a + " + " + b + " = " + (a + b));
		System.out.println(a + " - " + b + " = " + (a - b));
		System.out.println(a + " * " + b + " = " + (a * b));
		System.out.println(a + " / " + b + " = " + (a / b));
		System.out.println(a + " % " + b + " = " + (a % b));
	}

}

package fr.tableaux;

import java.util.Arrays;

public class TestArrayTri {

	public static void main(String[] args) {
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		
		Arrays.sort(array);

		System.out.println("Le tableau trié par ordre croissant contient les valeurs :");
		for(int i = 0, limite = array.length; i < limite; i++) {
			System.out.print(array[i] + " ");
		}

	}

}

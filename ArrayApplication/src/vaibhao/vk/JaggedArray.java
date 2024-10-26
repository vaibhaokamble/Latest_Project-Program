package vaibhao.vk;

import java.util.Scanner;

public class JaggedArray {

	public static void main(String[] args) {

		Scanner v = new Scanner(System.in);
		int a[][] = new int[3][];
		a[0] = new int[3];
		a[1] = new int[4];
		a[2] = new int[2];

		System.out.println("Enter the value of matrix");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = v.nextInt();
			}
		}
		System.out.println("Display the matrix ising jaagges array");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%d \t ", a[i][j]);
			}
			System.out.println("\n");
		}
	}

}

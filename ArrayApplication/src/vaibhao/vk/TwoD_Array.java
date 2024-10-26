package vaibhao.vk;

import java.util.Scanner;

public class TwoD_Array {

	public static void main(String[] args) {
		
		int a[][] = new int[3][3];
//		System.out.println("Size of A[0] = " + a[0].length);
//		System.out.println("Size of B[1] = " + a[1].length);
//		System.out.println("Size of C[2] = " + a[2].length);

		Scanner v= new Scanner(System.in);
		System.out.println("Enter the values in Matrix " );
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j]=v.nextInt();
			}
		}
		System.out.println("Display matrix  ");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%d\t" , a[i][j]);
			}
			System.out.println("\n");
		}
	}

}
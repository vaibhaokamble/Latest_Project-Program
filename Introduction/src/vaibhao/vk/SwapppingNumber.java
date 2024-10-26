package vaibhao.vk;

import java.util.*;

public class SwapppingNumber {

	public static void main(String[] args) {
		int a, b;
		Scanner v = new Scanner(System.in);
		System.out.println("Enter the value of A : ");
		a = v.nextInt();
		System.out.println("Enter the value of B : ");
		b = v.nextInt();
		System.out.println("Before Swapping : ");
		System.out.printf("A=%d \t\t B=%d\n", a, b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("After Swapping");
		System.out.printf("A=%d \t\t B=%d\n", a, b);
	}
}

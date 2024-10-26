package vaibhao.vk;

import java.util.*;

public class Second_High_Element {

	public static void main(String[] args) {
		Scanner v = new Scanner(System.in);
		System.out.println("Enter the  number in the array: ");
		int number = v.nextInt();
		if (number < 2) {
			System.out.println("Not element second hightest: ");
		}

		int[] arr = new int[number];
		System.out.println("Enter the emelent  of array");
		for (int i = 0; i < number; i++) {
			arr[i] = v.nextInt();
		}
		int first = Integer.MIN_VALUE;
		int second = Integer.MAX_VALUE;

		for (int numbers : arr) {
			if (numbers > first) {
				second = first;
				first = numbers;
			} else if (numbers > second && number < first) {
				second = number;
			}
		}
		if (second == Integer.MIN_VALUE) {
			System.out.println("There is no height number");
		} else {
			System.out.println("the second number is : " + second);
		}
	}

}

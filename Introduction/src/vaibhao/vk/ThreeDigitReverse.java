package vaibhao.vk;

import java.util.Scanner;

public class ThreeDigitReverse {

	public static void main(String[] args) {

		Scanner v = new Scanner(System.in);
		int number, reminder, reverse=0;
		
		System.out.println("Enter the any three number : ");
		number= v.nextInt();
		
		System.out.println("Before a reverse number : " +number);
		
		reminder = number % 10;
		number = number / 10;
		reverse = reverse + reminder * 100;
		
		reminder = number % 10;
		number = number / 10;
		reverse = reverse + reminder * 10;
		
		reminder = number % 10;
		number = number / 10;
		reverse = reverse + reminder * 1;

		System.out.println("After Reverse Number : " +reverse);
	}

}

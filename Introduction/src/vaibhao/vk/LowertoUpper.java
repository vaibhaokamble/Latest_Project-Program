package vaibhao.vk;

import java.util.Scanner;

public class LowertoUpper {

	public static void main(String[] args) {
		Scanner v= new Scanner(System.in);
		char ch;
		System.out.println("Enter charecter from keyboard");
		ch=v.next().charAt(0);
		System.out.printf("Before conversion %c" ,ch);
		if (ch>='a' && ch<='z') {
			int ascii=(int)ch-32;
			ch=(char)ascii;
		}
		
		System.out.printf("After conversion %c" ,ch);

	}

}

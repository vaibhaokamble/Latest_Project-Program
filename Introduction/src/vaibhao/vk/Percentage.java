package vaibhao.vk;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Percentage {

	public static void main(String[] args) {
		
		Scanner v= new Scanner(System.in);
		int s1, s2, s3, s4, s5, s6, aggrigate, percentage;
		System.out.println("Enter the six subject marks : ");
		s1=v.nextInt();
		s2=v.nextInt();
		s3=v.nextInt();
		s4=v.nextInt();
		s5=v.nextInt();
		s6=v.nextInt();

		aggrigate =  s1+s2+s3+s4+s5+s6;
		
		percentage = aggrigate / 6;
		System.out.println("percentage is " + percentage);
		
		if (percentage>40) {
			System.out.println("Student is passed");
		}
		else {
			System.out.println("Student is failed");
		}
	}

}

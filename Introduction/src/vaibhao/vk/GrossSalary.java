package vaibhao.vk;

import java.util.Scanner;

public class GrossSalary {

	public static void main(String[] args) {
	Scanner v= new Scanner(System.in);
	int bs, hra, da, gs;
	
	System.out.println("Enter the basic salary");
	bs= v.nextInt();
	
	da = (bs * 30)/100;
	
	hra = (bs * 30)/100;
	
	gs =  bs + da + hra;
	
	System.out.println("Total salary is : " + gs);
	}

}

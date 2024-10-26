package vaibhao.vk;

import java.util.Scanner;

public class ProfitLoss {

	public static void main(String[] args) {
		Scanner v=new Scanner(System.in);
		int sp, cp;
		System.out.println("Enter the selling price and cost price : ");
		sp = v.nextInt();
		cp = v.nextInt();
		
		if (sp > cp) {
			System.out.println("Profit " +(sp-cp));
		}
		else {
			System.out.println("Loss "+(cp-sp));
		}
	}

}

package vaibhao.vk;
import java.util.*;
class Addition{
	int a,b,c;
	void setValues(int x, int y) {
		a=x;
		b=y;
	}
	void showData() {
		c=a+b;
		System.out.println("The addition is :" +c);
	}
}
public class AdditionApp {
	public static void main(String [] args) {
		Scanner v= new Scanner(System.in);
		System.out.println("Enter the first value ");
		int a=v.nextInt();
		System.out.println("Enter the second value ");
		int b=v.nextInt();
		
		Addition addition=new Addition();
		addition.setValues(a, b);
		addition.showData();
	}
}

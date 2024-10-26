package vaibhao.vk;
import java.util.*;

class Power{
	int base,index,area;
	void setValue(int x, int y) {
		base=x;
		index=y;
	}
	int getPower() {
		area=base*index;
		return area;
	}
}
public class PowerApplication {

	public static void main(String[] args) {
		Scanner v= new Scanner(System.in);
		System.out.println("Enter the base: ");
		int base = v.nextInt();
		System.out.println("Enter the index: ");
		int index=v.nextInt();
		Power power=new Power();
		power.setValue(base, index);
		power.getPower();
	}

}

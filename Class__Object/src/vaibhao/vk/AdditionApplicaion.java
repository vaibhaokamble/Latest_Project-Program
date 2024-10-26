package vaibhao.vk;

class Addition{
	int a,b;
	void setValue(int x, int y) {
		a=x;
		b=y;
	}
	
	void show() {
		System.out.println("Addition is : " +(a+b));
	}
}
public class AdditionApplicaion {

	public static void main(String[] args) {
		Addition a= new Addition();
		a.setValue(10, 200);
		a.show();
	}

}

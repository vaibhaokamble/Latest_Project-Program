package vaibhao.vk;


public class Pattern {

	public static void main(String[] args) {
		int row = 10;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			for (int k = 1; k <= (row - i) * 2; k++) {
				System.out.print(" ");
			}
			for (int m = 0; m >= 1; m--) {
				System.out.print(m);
			}
			System.out.println();
		}

	}
}

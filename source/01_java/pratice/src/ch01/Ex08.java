package ch01;

public class Ex08 {

	public static void main(String[] args) {
		
		int[] coin = {500, 100, 50, 10};
		int[] coinUnit = new int[4];
		
		int money = 2680;
		
		for (int i = 0; i < coin.length; i++) {
			coinUnit[i] = money / coin[i];
			money %= coin[i];
			System.out.println(coin[i] + "Â¥¸®" + coinUnit[i] + "°³");
		}
	}
}

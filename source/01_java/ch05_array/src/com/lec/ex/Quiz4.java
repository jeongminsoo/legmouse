package com.lec.ex;

public class Quiz4 {

	public static void main(String[] args) {

		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;

		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 개수 : " + money / coinUnit[i]);
			money %= coinUnit[i];
		}
//		for (int coin : coinUnit) {
//			System.out.println(coin + "원 개수 : " + (money / coin));
//			money %= coin;
//		}
	}
}

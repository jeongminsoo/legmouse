package com.lec.ex;

public class Ex02 {

	public static void main(String[] args) {

		int tot = sum(10);
		System.out.println(tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(1, 10);
		System.out.println(tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(10, 100);
		System.out.println(tot);
		System.out.println(evenOdd(tot));
	}
	private static int sum(int to) {
		
		int result = 0;
		
		for(int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}
	
	private static int sum(int from, int to) {
		
		int result = 0;
		for(int i = from; i <= to; i++) {
			result += i;
		}
		
		return result;
	}
	private static String evenOdd(int value) {
		
		String result;
		
		if (value % 2 == 0) {
			result = "Â¦¼öÀÔ´Ï´Ù";
		} else {
			result = "È¦¼öÀÔ´Ï´Ù";
		}
		return result;
	}
}


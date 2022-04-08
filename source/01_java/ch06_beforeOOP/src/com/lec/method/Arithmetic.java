package com.lec.method;

public class Arithmetic {

	public int abs(int value) {
		
		int result = value >= 0 ? value : -value;
		
		return result;
	}
	
	public static int sum(int to) {
		
		int result = 0;
		
		for(int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}
	
	public static int sum(int from, int to) {
		
		int result = 0;
		for(int i = from; i <= to; i++) {
			result += i;
		}
		
		return result;
	}
	public static String evenOdd(int value) {
		
		String result;
		
		if (value % 2 == 0) {
			result = "Â¦¼öÀÔ´Ï´Ù";
		} else {
			result = "È¦¼öÀÔ´Ï´Ù";
		}
		return result;
	}
}

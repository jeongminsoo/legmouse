package com.lec.loop;

public class Ex08_for_while {

	public static void main(String[] args) {
		
		int sum = 0;
		int j = 1;
		
		while (j<= 100) {
			if (j % 3 == 0) {
				sum += j;
			}
			j++;
		}
		
//		for (int i = 1; i <= 100; i++) {
//			if (i % 3 == 0) {
//				sum += i;
//			}
//		}
		System.out.println(sum);
	}
}

package com.lec.ex;

import java.util.Scanner;

public class Ex06_factorial {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int su;
		
		do {
			System.out.print("수를 입력하세요 : ");
			su = sc.nextInt();
			
		} while(su <= 0);
		
		long result = factorial(su);
		
		System.out.printf("%d! = %d", su, result);
		
		sc.close();
	}
	
//	private static long factorial(int i) {
//		
//		int result = 1;
//		
//		for(int j = 1; j <= i; j++) {
//			result *= j;
//		}
//		return result;
//	}
	
	private static long factorial(int i) {
		if (i == 1) {
			return 1;
		} else {
			return i * factorial(i-1);
		}
	}
}

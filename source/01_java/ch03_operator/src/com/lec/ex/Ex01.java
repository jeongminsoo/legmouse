package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {
		
		int n1 = 33, n2 = 10;
		int result;
		double resultDouble;  // 나누기의 결과
		
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %.2f\n", n1, '/', n2, resultDouble);
		
		if (n1 % 2 == 0) {
			System.out.println("n1은 짝수");
		} else {
			System.out.println("n1은 홀수");
		}
		
		if (n1 % 5 == 0) {
			System.out.println("n1은 5의 배수");
		} else {
			System.out.println("n1은 5의 배수가 아님");
		}
	}
}

package com.lec.ex;

public class VarEx02 {

	public static void main(String[] args) {
		
		int i = 10;
		byte j = 10;
		double h = 10.15;
		i = 5;
		System.out.println("i = " + i + "\t j = " + j + "\t h = " + h);
		
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.print("c1 = " + c1 + "\t c2 = " + c2);
		System.out.printf("c1 = %c \t c2 = %c\n", c1, c2);
		// %c - 문자 / %d - 정수 / %f - 실수 / %s - 문자열
		System.out.printf("i=%d, j=%d, h=%.2f \n", i, j, h);
		
		System.out.println("끝");
	}

}

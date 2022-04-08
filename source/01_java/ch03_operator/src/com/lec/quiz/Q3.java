package com.lec.quiz;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("수를 입력하세요 : ");
		
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		
		String result1 = n1 == n2 ? "O" : "X";
		System.out.println(result1);
		
		String result2 = n1 > n2 ? "O" : "X";
		System.out.println(result2);
		
		scanner.close();
		
	}
}

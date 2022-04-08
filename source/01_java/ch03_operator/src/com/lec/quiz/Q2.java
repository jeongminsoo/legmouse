package com.lec.quiz;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		
		int i = scanner.nextInt();
		
		String result = i % 2 == 0 ? "짝수" : "홀수";
		System.out.println(result);
		
		scanner.close();
	}
}

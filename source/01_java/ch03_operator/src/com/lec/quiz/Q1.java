package com.lec.quiz;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		
		int i = scanner.nextInt();
		
		String result = i % 3 == 0 ? "입력하신 i는 3의 배수입니다." : "입력하신 i는 3의 배수가 아닙니다.";	
		System.out.println(result);
		
		scanner.close();
		
		
	}
}

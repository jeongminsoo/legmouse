package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사칙연산을 할 첫번째 수 : ");
		int i = sc.nextInt();
		System.out.print("사칙연산을 할 두번째 수 : ");
		int j = sc.nextInt();
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j));
		} catch(ArithmeticException e) {
			System.out.println("예외 메세지 : " + e.getMessage());
			// e.printStackTrace();
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		sc.close();
	}
}

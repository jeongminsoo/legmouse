package com.lec.quiz;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("???? ?Է??ϼ??? : ");
		
		int i = scanner.nextInt();
		
		String result = i % 2 == 0 ? "¦??" : "Ȧ??";
		System.out.println(result);
		
		scanner.close();
	}
}

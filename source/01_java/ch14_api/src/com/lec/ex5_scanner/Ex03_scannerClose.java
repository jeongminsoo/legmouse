package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println("입력한 이름은 " + name);
		nickName();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.println("입력한 나이는 " + age);
		sc.close();
	}
	private static void nickName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("별명 : ");
		System.out.println("입력한 별명은 " + sc.nextLine());
	}
}

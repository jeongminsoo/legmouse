package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.println("�Է��� �̸��� " + name);
		nickName();
		System.out.print("���� : ");
		int age = sc.nextInt();
		System.out.println("�Է��� ���̴� " + age);
		sc.close();
	}
	private static void nickName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		System.out.println("�Է��� ������ " + sc.nextLine());
	}
}

package com.lec.quiz;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		
		int age = scanner.nextInt();
		
		String result = age >= 65 ? "��ο��" : "�Ϲ�";
		System.out.println(result);
		
		scanner.close();
	}
}

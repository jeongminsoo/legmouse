package com.lec.ex;

import java.util.Scanner;

public class Today {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int su;

		do {
			System.out.print("���� �Է��ϼ��� : ");
			su = sc.nextInt();
		} while (su < 2 || su > 9);

		method(su);

		sc.close();
	}

	private static void method(int num) {

		System.out.printf("[%d��]\n", num);

		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num * i);
		}
	}
}

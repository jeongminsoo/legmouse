package com.lec.loop;

import java.util.Scanner;

public class Ex09_do_while {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		do {
			System.out.print("¦���� �Է��ϼ��� : ");
			num = sc.nextInt();
		} while (num % 2 != 0);
		System.out.print("�Է��Ͻ� ���� ¦��" + num + "�Դϴ�.");
		
		sc.close();
	}
}

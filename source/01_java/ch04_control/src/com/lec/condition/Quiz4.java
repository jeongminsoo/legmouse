package com.lec.condition;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �����? : ");
		int num = sc.nextInt();
		
		if (num == 0) {
			System.out.print("����");
		} else if (num == 1) {
			System.out.print("����");
		} else if (num == 2) {
			System.out.print("��");
		} else {
			System.out.print("0, 1, 2 �� ���� ���� �� �ϳ��� �Է��ϼ���.");
		}
		sc.close();
	}
}

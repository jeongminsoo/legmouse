package com.lec.condition;

import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		
		int num2 = (int)(Math.random()*3);
		
		if (num1 == 0) {
			System.out.println("����� : ����");
		} else if (num1 == 1) {
			System.out.println("����� : ����");
		} else if (num1 == 2) {
			System.out.println("����� : ��");
		} else {
			System.out.println("��ȿ���� �ʴ� ���Դϴ�.");
			num1 = 3;
		}
		
		if (num1 != 3) {
			if (num2 == 0) {
				System.out.println("��ǻ�� : ����");
			} else if (num2 == 1) {
				System.out.println("��ǻ�� : ����");
			} else if (num2 == 2) {
				System.out.println("��ǻ�� : ��");
			} else {
				System.out.println("��ȿ���� �ʴ� ���Դϴ�.");
			}
		} else {
			System.out.println("��ȿ���� �ʴ� ���Դϴ�.");
		}

		if (((num1 == 0) && (num2 == 2)) || ((num1 == 1) && (num2 == 0)) || ((num1 == 2) && (num2 == 1))) {
			System.out.println("����ڰ� �̰���ϴ�.");
		} else if (((num1 == 2) && (num2 == 0)) || ((num1 == 0) && (num2 == 1)) || ((num1 == 1) && (num2 == 2))) {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		} else if (num1 == num2) {
			System.out.println("�����ϴ�.");
		} else {
			System.out.println("��ȿ���� �ʴ� ���Դϴ�.");
		}
		
		sc.close();
	}
}

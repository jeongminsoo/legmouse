package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06_telPrint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String tel;
		
		do {
			System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
			tel = sc.next();
			
			System.out.println("�Է��� ��ȭ��ȣ : " + tel);
			System.out.print("¦����° ���ڿ� : ");
			for (int idx = 0; idx < tel.length(); idx++) {
				if (idx % 2 == 0) {
					System.out.print(tel.charAt(idx));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.print("���ڸ� �Ųٷ� : ");
			for (int idx = tel.length()-1; idx >= 0; idx--) {
				System.out.print(tel.charAt(idx));
			}
			System.out.println();
			System.out.println("��ȭ��ȣ �Ǿ��ڸ��� : " + tel.substring(0, tel.indexOf(0, '-')));
			System.out.println("��ȭ��ȣ ���ڸ�sms : " + tel.substring(8));
		}


		while (!tel.equalsIgnoreCase("x"));
			
		System.out.println("���α׷� ����");
		
		}
		
}
package com.lec.ex1_string;

import java.util.Scanner;

public class Ex07_serchTel {

	public static void main(String[] args) {
		
		String[] tel = {"010-9999-9999", "02-8888-8888", "010-7777-8888"};
		
		Scanner sc = new Scanner(System.in);
		String serchTel;
		System.out.println("��ȭ��ȣ ���ڸ��� �Է��ϼ��� : ");
		
		serchTel = sc.next();
	
		boolean serchOk = false;
		
		for (int idx = 0; idx < tel.length; idx++) {
			if ( serchTel.equals(tel[idx].substring(tel[idx].lastIndexOf('-')+1))) {
				System.out.println("�˻��� ��ȭ��ȣ�� " + tel[idx] + " �Դϴ�.");
				serchOk = true;
			}
		}
		if (!serchOk) {
			System.out.println("�˻��� ��ȭ��ȣ�� �����ϴ�.");
		}
	}
}

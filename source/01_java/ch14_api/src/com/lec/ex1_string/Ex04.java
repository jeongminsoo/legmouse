package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��ϼ��� : ");
		String fn = sc.next();
		
		if (fn.charAt(7) == '2') {
			System.out.println("����");
		} else if (fn.charAt(7) == '1') {
			System.out.println("����");
		} else {
			System.out.println("����?");
		}
		sc.close();
	}
}

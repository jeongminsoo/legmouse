package com.lec.ex6_wrapper;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		String numStr = sc.nextLine();
		System.out.println("�Է��� ������ " + numStr);
		numStr = numStr.trim();
		numStr = numStr.replaceAll("[a-zA-Z��-�R]", "");
		int num = Integer.parseInt(numStr);
		System.out.println("������ ������ " + num);
	}
}

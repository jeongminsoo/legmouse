package com.lec.quiz;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		
		int i = scanner.nextInt();
		
		String result = i % 3 == 0 ? "�Է��Ͻ� i�� 3�� ����Դϴ�." : "�Է��Ͻ� i�� 3�� ����� �ƴմϴ�.";	
		System.out.println(result);
		
		scanner.close();
		
		
	}
}

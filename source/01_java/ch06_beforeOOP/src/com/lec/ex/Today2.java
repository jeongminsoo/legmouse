package com.lec.ex;

import java.util.Scanner;

public class Today2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է��ϼ��� : ");
		int idx = sc.nextInt();
		
		System.out.println("�Է��� ���� ���밪 : " + abs(idx));
		sc.close();
	}
	
	private static int abs(int num) {
		
		int result;
		
		if (num >= 0 ) {
			result = num;
		} else {
			result = -num;
		}
		return result;
		
		// return result = num >= 0 ? num : -num;
	}
}

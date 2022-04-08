package com.lec.ex;

import java.util.Scanner;

public class Today2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요 : ");
		int idx = sc.nextInt();
		
		System.out.println("입력한 수의 절대값 : " + abs(idx));
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

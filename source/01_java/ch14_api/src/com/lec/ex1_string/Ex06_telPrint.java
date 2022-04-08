package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06_telPrint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String tel;
		
		do {
			System.out.print("전화번호를 입력하세요 : ");
			tel = sc.next();
			
			System.out.println("입력한 전화번호 : " + tel);
			System.out.print("짝수번째 문자열 : ");
			for (int idx = 0; idx < tel.length(); idx++) {
				if (idx % 2 == 0) {
					System.out.print(tel.charAt(idx));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.print("문자를 거꾸로 : ");
			for (int idx = tel.length()-1; idx >= 0; idx--) {
				System.out.print(tel.charAt(idx));
			}
			System.out.println();
			System.out.println("전화번호 맨앞자리는 : " + tel.substring(0, tel.indexOf(0, '-')));
			System.out.println("전화번호 뒷자리sms : " + tel.substring(8));
		}


		while (!tel.equalsIgnoreCase("x"));
			
		System.out.println("프로그램 종료");
		
		}
		
}
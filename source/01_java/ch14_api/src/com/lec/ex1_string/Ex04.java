package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요 : ");
		String fn = sc.next();
		
		if (fn.charAt(7) == '2') {
			System.out.println("여자");
		} else if (fn.charAt(7) == '1') {
			System.out.println("남자");
		} else {
			System.out.println("뭐니?");
		}
		sc.close();
	}
}

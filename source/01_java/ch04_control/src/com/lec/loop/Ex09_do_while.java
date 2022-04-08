package com.lec.loop;

import java.util.Scanner;

public class Ex09_do_while {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = sc.nextInt();
		} while (num % 2 != 0);
		System.out.print("입력하신 수는 짝수" + num + "입니다.");
		
		sc.close();
	}
}

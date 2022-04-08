package com.lec.loop;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원하는 구구단을 입력하세요 : ");
		int num = sc.nextInt();
		
		System.out.printf("[%d단]\n", num);
		
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num*i);
		}
		sc.close();
	}
}

package com.lec.condition;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num >= 0) {
			System.out.println("절대값 : " + num);
		} else {
			System.out.println("절대값 : "+ -(num));
		}
		sc.close();
	}
}

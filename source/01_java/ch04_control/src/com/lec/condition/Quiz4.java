package com.lec.condition;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("무엇을 낼까요? : ");
		int num = sc.nextInt();
		
		if (num == 0) {
			System.out.print("가위");
		} else if (num == 1) {
			System.out.print("바위");
		} else if (num == 2) {
			System.out.print("보");
		} else {
			System.out.print("0, 1, 2 세 가지 숫자 중 하나만 입력하세요.");
		}
		sc.close();
	}
}

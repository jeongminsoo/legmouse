package com.lec.condition;

import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요 : ");
		int num1 = sc.nextInt();
		
		int num2 = (int)(Math.random()*3);
		
		if (num1 == 0) {
			System.out.println("사용자 : 가위");
		} else if (num1 == 1) {
			System.out.println("사용자 : 바위");
		} else if (num1 == 2) {
			System.out.println("사용자 : 보");
		} else {
			System.out.println("유효하지 않는 값입니다.");
			num1 = 3;
		}
		
		if (num1 != 3) {
			if (num2 == 0) {
				System.out.println("컴퓨터 : 가위");
			} else if (num2 == 1) {
				System.out.println("컴퓨터 : 바위");
			} else if (num2 == 2) {
				System.out.println("컴퓨터 : 보");
			} else {
				System.out.println("유효하지 않는 값입니다.");
			}
		} else {
			System.out.println("유효하지 않는 값입니다.");
		}

		if (((num1 == 0) && (num2 == 2)) || ((num1 == 1) && (num2 == 0)) || ((num1 == 2) && (num2 == 1))) {
			System.out.println("사용자가 이겼습니다.");
		} else if (((num1 == 2) && (num2 == 0)) || ((num1 == 0) && (num2 == 1)) || ((num1 == 1) && (num2 == 2))) {
			System.out.println("컴퓨터가 이겼습니다.");
		} else if (num1 == num2) {
			System.out.println("비겼습니다.");
		} else {
			System.out.println("유효하지 않는 값입니다.");
		}
		
		sc.close();
	}
}

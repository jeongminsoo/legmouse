package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.print("사칙연산을 할 첫번째 수 : ");
				i = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("예외 메세지 : " + e.getMessage());
				System.out.println("정수를 반드시 입력하세요");
				sc.nextLine();
			}
		} while(true);
		try {	
			System.out.print("사칙연산을 할 두번째 수 : ");
			j = sc.nextInt();
			System.out.println("i = " + i + ", j = " + j);
			System.out.println("i * j = " + (i * j));
			System.out.println("i / j = " + (i / j));
		} catch (InputMismatchException e) {
			System.out.println("예외 메세지 : " + e.getMessage());
			System.out.println("두번째 수를 잘못 입력하시면 1로 초기화 됩니다");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("모든 예외는 다 이쪽으로" + e.getMessage());
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		sc.close();
	}
}

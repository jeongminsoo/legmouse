package com.lec.condition;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int kor = sc.nextInt();
		
		System.out.print("���� : ");
		int eng = sc.nextInt();
		
		System.out.print("���� : ");
		int math = sc.nextInt();
		
		double avg = (kor + eng + math) / 3.0;
		
		if (kor >= avg) {
			System.out.printf("���� ������ ������� (%4.2f) �̻�\n", avg);
		} else {
			System.out.printf("���� ������ ������� (%4.2f) ����\n", avg);
		}
		if (eng >= avg) {
			System.out.printf("���� ������ ������� (%4.2f) �̻�\n", avg);
		} else {
			System.out.printf("���� ������ ������� (%4.2f) ����\n", avg);
		}
		if (math >= avg) {
			System.out.printf("���� ������ ������� (%4.2f) �̻�\n", avg);
		} else {
			System.out.printf("���� ������ ������� (%4.2f) ����\n", avg);
		}
		sc.close();
	}
}

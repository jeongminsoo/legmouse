package com.lec.quiz;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���� ������ �Է��ϼ��� : ");
		int korScore = scanner.nextInt();
		System.out.println("���� ������ �Է��ϼ��� : ");
		int engScore = scanner.nextInt();
		System.out.println("���� ������ �Է��ϼ��� : ");
		int mathScore = scanner.nextInt();
		
		int sum = korScore + engScore + mathScore;
		double average = sum / 3.0;
		
		System.out.printf("���� : %d\n", korScore);
		System.out.printf("���� : %d\n", engScore);
		System.out.printf("���� : %d\n", mathScore);
		
		System.out.printf("���� : %d\n", sum);
		System.out.printf("��� : %.2f\n", average);
		
		scanner.close();
	}
}

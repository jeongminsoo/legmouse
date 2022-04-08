package com.lec.quiz;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요 : ");
		int korScore = scanner.nextInt();
		System.out.println("영어 점수를 입력하세요 : ");
		int engScore = scanner.nextInt();
		System.out.println("수학 점수를 입력하세요 : ");
		int mathScore = scanner.nextInt();
		
		int sum = korScore + engScore + mathScore;
		double average = sum / 3.0;
		
		System.out.printf("국어 : %d\n", korScore);
		System.out.printf("영어 : %d\n", engScore);
		System.out.printf("수학 : %d\n", mathScore);
		
		System.out.printf("총점 : %d\n", sum);
		System.out.printf("평균 : %.2f\n", average);
		
		scanner.close();
	}
}

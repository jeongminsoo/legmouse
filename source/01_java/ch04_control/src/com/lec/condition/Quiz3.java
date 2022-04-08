package com.lec.condition;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		double avg = (kor + eng + math) / 3.0;
		
		if (kor >= avg) {
			System.out.printf("국어 점수는 평균점수 (%4.2f) 이상\n", avg);
		} else {
			System.out.printf("국어 점수는 평균점수 (%4.2f) 이하\n", avg);
		}
		if (eng >= avg) {
			System.out.printf("영어 점수는 평균점수 (%4.2f) 이상\n", avg);
		} else {
			System.out.printf("영어 점수는 평균점수 (%4.2f) 이하\n", avg);
		}
		if (math >= avg) {
			System.out.printf("수학 점수는 평균점수 (%4.2f) 이상\n", avg);
		} else {
			System.out.printf("수학 점수는 평균점수 (%4.2f) 이하\n", avg);
		}
		sc.close();
	}
}

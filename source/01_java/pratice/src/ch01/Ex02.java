package ch01;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		int su = 5;
		System.out.println(su % 2 == 0 ? "짝수" : "홀수");
		
		Scanner sc = new Scanner(System.in);
		
		int su1;
		int su2;
		System.out.print("첫번째 수를 입력하세요 : ");
		su1 = sc.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
		su2 = sc.nextInt();
		
		System.out.println(su1 == su2 ? "O" : "X");
		System.out.println(su1 > su2 ? "O" : "X");
		
		
		int age;
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		System.out.println(age >= 65 ? "경로우대" : "일반");
		
		
		
		
		sc.close();
	}
}

package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��Ģ������ �� ù��° �� : ");
		int i = sc.nextInt();
		System.out.print("��Ģ������ �� �ι�° �� : ");
		int j = sc.nextInt();
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		System.out.println("i / j = " + (i / j));
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		sc.close();
	}
}

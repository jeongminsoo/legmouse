package com.lec.ex6_wrapper;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		String numStr = sc.nextLine();
		System.out.println("입력한 정수는 " + numStr);
		numStr = numStr.trim();
		numStr = numStr.replaceAll("[a-zA-Z가-힣]", "");
		int num = Integer.parseInt(numStr);
		System.out.println("변형된 정수는 " + num);
	}
}

package com.lec.ex;

import java.util.Scanner;

public class Ex05_avg {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] arrName = {"영희", "철수", "길동", "영수", "말자"};
		int[] arrHeight = new int[arrName.length];
		int totalHeight = 0;
		
		for(int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i] + "의 키는? ");
			arrHeight[i] = sc.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("평균키는 " + (double)totalHeight/arrName.length);
		sc.close();
	}
}

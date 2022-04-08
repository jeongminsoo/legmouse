package com.lec.ex;

import java.util.Scanner;

public class Ex05_minMax {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] arrName = { "영희", "철수", "길동", "영수", "말자" };
		int[] arrHeight = new int[arrName.length];
		int totalHeight = 0;

		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i] + "의 키는? ");
			arrHeight[i] = sc.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("평균키는 " + (double) totalHeight / arrName.length);

		int maxHeight = 0;
		int minHeight = 300;
		int maxIdx = 0;
		int minIdx = 0;

		for (int j = 0; j < arrName.length; j++) {
			if (arrHeight[j] > maxHeight) {
				maxHeight = arrHeight[j];
				maxIdx = j;
			}
			if (arrHeight[j] < minHeight) {
				minHeight = arrHeight[j];
				minIdx = j;
			}
		}

		System.out.println("키가 가장 큰 사람의 이름 : " + arrName[maxIdx]);
		System.out.println("키가 가장 큰 사람의 키 : " + maxHeight);

		System.out.println("키가 가장 작은 사람의 이름 : " + arrName[minIdx]);
		System.out.println("키가 가장 작은 사람의 이름 : " + minHeight);

		sc.close();
	}
}

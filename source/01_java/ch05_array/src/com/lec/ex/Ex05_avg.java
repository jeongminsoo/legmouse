package com.lec.ex;

import java.util.Scanner;

public class Ex05_avg {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] arrName = {"����", "ö��", "�浿", "����", "����"};
		int[] arrHeight = new int[arrName.length];
		int totalHeight = 0;
		
		for(int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i] + "�� Ű��? ");
			arrHeight[i] = sc.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("���Ű�� " + (double)totalHeight/arrName.length);
		sc.close();
	}
}

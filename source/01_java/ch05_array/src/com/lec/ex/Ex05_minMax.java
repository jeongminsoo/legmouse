package com.lec.ex;

import java.util.Scanner;

public class Ex05_minMax {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] arrName = { "����", "ö��", "�浿", "����", "����" };
		int[] arrHeight = new int[arrName.length];
		int totalHeight = 0;

		for (int i = 0; i < arrName.length; i++) {
			System.out.print(arrName[i] + "�� Ű��? ");
			arrHeight[i] = sc.nextInt();
			totalHeight += arrHeight[i];
		}
		System.out.println("���Ű�� " + (double) totalHeight / arrName.length);

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

		System.out.println("Ű�� ���� ū ����� �̸� : " + arrName[maxIdx]);
		System.out.println("Ű�� ���� ū ����� Ű : " + maxHeight);

		System.out.println("Ű�� ���� ���� ����� �̸� : " + arrName[minIdx]);
		System.out.println("Ű�� ���� ���� ����� �̸� : " + minHeight);

		sc.close();
	}
}

package com.lec.ex;

public class Quiz3 {

	public static void main(String[] args) {

		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int sum = 0;
		int maxNum = 0;
		int minNum = 200;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] > maxNum) {
				maxNum = arr[i];
			}

			if (arr[i] < minNum) {
				minNum = arr[i];
			}
		}
		System.out.printf("�հ� : %d\t��� : %.2f\n", sum, (double) sum / arr.length);
		System.out.printf("�ִ밪 : %d\t�ּҰ� : %d\n", maxNum, minNum);
	}
}

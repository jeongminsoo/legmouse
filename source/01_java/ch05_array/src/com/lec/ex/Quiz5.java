package com.lec.ex;

public class Quiz5 {

	public static void main(String[] args) {

		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int[] des = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			des[i] = arr[i];
		}

		for (int j = 0; j < arr.length - 1; j++) {
			for (int k = j + 1; k < arr.length; k++) {
				if (des[j] > des[k]) {
					int idx = des[j];
					des[j] = des[k];
					des[k] = idx;
				}
			}
		}
		// 오름차순 정렬 : Arrays.sort(des);
		
		for (int num : arr) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		
		for (int num : des) {
			System.out.print(num + " ");
		}
	}
}

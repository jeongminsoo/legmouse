package com.lec.ex;

public class Ex06_multiDimensional {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 }, };

		System.out.println(arr[2]);
		System.out.println(arr2[1][1]);

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.printf("arr2[%d][%d] = %d\n", i, j, arr2[i][j]);
			}
		}
	}
}

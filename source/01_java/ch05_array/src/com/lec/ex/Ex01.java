package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {

		int[] iArr = { 10, 20, 30, 40, 50 };
		iArr[2] = 300;
		System.out.println(iArr[0]);
		System.out.println(iArr[1]);
		System.out.println(iArr[2]);
		System.out.println(iArr[3]);
		System.out.println(iArr[4]);

		for (int j = 0; j < iArr.length; j++) {
			System.out.println(iArr[j]);
		}

		int[] iArr2 = new int[5];
		for (int j = 0; j < iArr2.length; j++) {
			System.out.printf("iArr2[%d] = %d\n", j, iArr2[j]);
		}
		iArr2[0] = 999;
		iArr2[1] = 888;

		for (int j = 0; j < iArr2.length; j++) {
			System.out.printf("iArr2[%d] = %d\n", j, iArr2[j]);
		}
		
		int[] iArr3;
		iArr3 = new int[3];
		for (int j = 0; j < iArr3.length; j++) {
			System.out.printf("iArr3[%d] = %d\n", j, iArr3[j]);
		}
	}
}

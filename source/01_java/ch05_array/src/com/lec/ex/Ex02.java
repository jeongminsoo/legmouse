package com.lec.ex;

public class Ex02 {

	public static void main(String[] args) {
		
		int[] arr = new int[3];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
		
		for(int j : arr) {
			System.out.println(j);
		}
		
		for(int k = 0; k < arr.length; k++) {
			arr[k] = 5;
		}
		
		for(int j : arr) {
			System.out.println(j);
		}
	}
}

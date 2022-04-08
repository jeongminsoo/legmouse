package com.lec.ex;

public class Ex03_reference {

	public static void main(String[] args) {
		
		int i = 10;
		int j = 10;
		j = 99;
		System.out.printf("i = %d, j = %d\n", i, j);
		
		int[] score = {100, 10, 20, 30, 40};
		
		int[] s = score;
		
		s[0] = 99;
		
		for(int k = 0; k < score.length; k++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", k, score[k], k, s[k]);
		}
	}
}

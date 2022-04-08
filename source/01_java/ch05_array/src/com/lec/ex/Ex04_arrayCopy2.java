package com.lec.ex;

public class Ex04_arrayCopy2 {

	public static void main(String[] args) {
		
		int[] score = {100, 10, 20, 30, 40};
		int[] s = new int[score.length];
		
		System.arraycopy(score, 0, s, 0, score.length);
		
		s[0] = 999;
		
		for(int k = 0; k < score.length; k++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", k, score[k], k, s[k]);
		}
	}
}

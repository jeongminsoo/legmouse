package com.lec.ex3_math;

import java.util.Random;

public class Ex04_lotto {

	public static void main(String[] args) {
		
		int[] lotto = new int[6];
		
		Random random = new Random();
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = random.nextInt(45)+1;
		}
		for (int l : lotto) {
			System.out.print(l + " ");
		}
	}
}

package com.lec.ex3_math;

import java.util.Random;

public class Ex04 {

	public static void main(String[] args) {
		
		int[] lotto = new int[6];
		
		Random random = new Random();
		
		for (int idx = 0; idx < lotto.length; idx++) {
//			lotto[i] = random.nextInt(45)+1;
			int temp = random.nextInt(45) + 1;
			boolean ok = true;
			for(int i = 0; i < idx; i++) {
				if (temp == lotto[i]) {
					idx--;
					ok = false;
					break;
				}
			}
			if (ok) {
				lotto[idx] = temp;
			}
		}
		for (int l : lotto) {
			System.out.print(l + " ");
		}
	}
}

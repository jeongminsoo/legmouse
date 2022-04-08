package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;
//import java.util.TreeSet;

public class Ex02_Lotto {

	public static void main(String[] args) {
		
		HashSet<Integer> lotto = new HashSet<Integer>();
		
//		TreeSet<Integer> lotto = new TreeSet<Integer>();

		Random random = new Random();
		
		int count = 0;
		
		while (lotto.size() < 6) {
			lotto.add(random.nextInt(45) + 1);
			count++;
		}
		System.out.println(count);
		System.out.println(lotto);
	}
}

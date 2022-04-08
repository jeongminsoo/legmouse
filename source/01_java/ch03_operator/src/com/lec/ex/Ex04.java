package com.lec.ex;

public class Ex04 {

	public static void main(String[] args) {
		
		int i = 1;
		int j = 10;
		int h = 10;
		
		System.out.println("&&(AND) (i > j) && (++j > h) : " + ((i > j) && (++j > h)));
		System.out.println(j);
		
		System.out.println("||(OR) (i > j) || (++j > h) : " + ((i > j) || (++j > h)));
		System.out.println(j);
		
	}
}

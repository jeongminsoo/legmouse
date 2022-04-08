package com.lec.ex;

public class Ex06 {

	public static void main(String[] args) {
		
		int n1 = 10 * 3;
		
		n1 += 10;
		n1 *= 3;
		
		System.out.println(n1);
		
		int n2 = n1 = 10;
		System.out.println("n1 = " + n1 + "\nn2 = " + n2);
	}
}

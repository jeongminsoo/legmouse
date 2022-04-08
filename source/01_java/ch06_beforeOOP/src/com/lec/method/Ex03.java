package com.lec.method;

public class Ex03 {

	public static void main(String[] args) {
		
		Arithmetic ari = new Arithmetic();
		
		int tot = Arithmetic.sum(10);
		
		System.out.println(tot);
		System.out.println(Arithmetic.evenOdd(tot));
		System.out.println(ari.abs(-8));
	}
}

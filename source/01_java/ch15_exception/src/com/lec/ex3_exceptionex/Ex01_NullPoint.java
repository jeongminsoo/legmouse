package com.lec.ex3_exceptionex;

public class Ex01_NullPoint {

	public static void main(String[] args) {
		
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase());
		greeting = null;
		System.out.println(greeting.toUpperCase());
	}
}

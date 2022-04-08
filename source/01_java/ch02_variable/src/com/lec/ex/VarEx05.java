package com.lec.ex;

public class VarEx05 {

	public static void main(String[] args) {
		
		char c = '씨';
		long l = 220000000l;
		float f = 3.14159265359f;
		double d = 3.14159265359;
		boolean b = true;
		System.out.println("c는 " + c);
		System.out.println("l는 " + l);
		System.out.println("f는 " + f);
		System.out.println("d는 " + d);
		System.out.println("b는 " + b);
		
		float f1;
		f1 = 10.1f;
		d = 10.1;
		
		System.out.println("f1 = " + f1);
		if ( f1 == d ) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
	}
}

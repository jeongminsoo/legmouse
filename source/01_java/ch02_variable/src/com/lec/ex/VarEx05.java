package com.lec.ex;

public class VarEx05 {

	public static void main(String[] args) {
		
		char c = '��';
		long l = 220000000l;
		float f = 3.14159265359f;
		double d = 3.14159265359;
		boolean b = true;
		System.out.println("c�� " + c);
		System.out.println("l�� " + l);
		System.out.println("f�� " + f);
		System.out.println("d�� " + d);
		System.out.println("b�� " + b);
		
		float f1;
		f1 = 10.1f;
		d = 10.1;
		
		System.out.println("f1 = " + f1);
		if ( f1 == d ) {
			System.out.println("����");
		}
		else {
			System.out.println("�ٸ���");
		}
	}
}

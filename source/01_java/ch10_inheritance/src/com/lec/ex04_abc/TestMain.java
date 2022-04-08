package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		
	
		S s = new S();
		S a = new A();
		S b = new B();
		S c = new C();
		
		S[] arr = {s, a, b, c};
		
		for (S obj : arr) {
			System.out.println(obj.s);
		}
		
	}
}

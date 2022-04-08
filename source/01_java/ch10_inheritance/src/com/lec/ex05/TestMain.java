package com.lec.ex05;

public class TestMain {

	public static void main(String[] args) {
		
		Super s = new Super(1);
		System.out.println(s.s);
		
		Child1 c1 = new Child1(10);
		System.out.println(c1.s);
		System.out.println(c1.c1);
		
		Child2 c2 = new Child2(100);
		System.out.println(c2.s);
		System.out.println(c2.c2);
		
		GrandChild gc = new GrandChild(1000);
		System.out.println(gc.s);
		System.out.println(gc.c1);
		System.out.println(gc.gc);
	}
}

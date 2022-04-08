package com.lec.ex08_superdot;

public class TestMain {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
		
		System.out.println(child.getI());
		child.method();
		
		ParentClass child1 = new ChildClass();
		System.out.println(child1.getI());
	}
}

package com.lec.ex10_aorb;

public class TestMain {

	public static void main(String[] args) {
		
		User user = new User();
		A a = new A();
		I i = new A();
		B b = new B();
		
		user.use(a);
		user.use(i);
		user.use(b);
	}
}

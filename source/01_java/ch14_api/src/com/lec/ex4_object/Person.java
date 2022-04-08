package com.lec.ex4_object;

public class Person {

	private long juminNo; // 9512121025252

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public String toString() {
		return "Person [juminNo=" + juminNo + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		} else {
			return false;
		}
	}
}

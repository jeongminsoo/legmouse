package com.lec.ex13;

public class Staff extends Person {
	
	public static int sfNum = 0;
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++sfNum;
		setNo("staff" + sfNum);
	}
	@Override
	public void print() {
		super.print();
		System.out.println(" (ºÎ¼­)" + department);
	}
}

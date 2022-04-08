package com.lec.ex10_customer;

public class Staff extends Person {

	private String hireDate;
	private String department;
	
	public Staff(String name, String tel, String hireDate, String department) {
		super(name, tel);
		this.hireDate = hireDate;
		this.department = department;
	}
	@Override
	public String infoString() {
		return super.infoString() + "[입사일]" + hireDate + "[부서]" + department;
	}
}

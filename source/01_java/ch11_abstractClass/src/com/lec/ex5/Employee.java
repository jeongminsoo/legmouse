package com.lec.ex5;

public abstract class Employee {

	private final double INCEN_PERCENT = 0.1;
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay();

	public final int computeIncentive() { // 월급이 200만원 이상일 경우에만 인센티브(10%) 지급
		int incen = 0;
		if (computePay() > 2000000) {
			incen = (int) (computePay() * INCEN_PERCENT);
		}
		return incen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

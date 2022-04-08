package com.lec.ex5;

public abstract class Employee {

	private final double INCEN_PERCENT = 0.1;
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay();

	public final int computeIncentive() { // ������ 200���� �̻��� ��쿡�� �μ�Ƽ��(10%) ����
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

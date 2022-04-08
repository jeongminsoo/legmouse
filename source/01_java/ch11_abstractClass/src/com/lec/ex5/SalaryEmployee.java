package com.lec.ex5;

public class SalaryEmployee extends Employee {

	private int annalSalary;

	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public int computePay() { // ¿ù±Þ = ¿¬ºÀ / 14
		return annalSalary / 14;
	}

}

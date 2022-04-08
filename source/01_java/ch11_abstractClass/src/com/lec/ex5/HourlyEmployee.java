package com.lec.ex5;

public class HourlyEmployee extends Employee {

	private int hoursWorked;
	private int moneyPerHour;

	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}

	@Override
	public int computePay() { // 월급 = 한달 일한 시간 * 시급
		return hoursWorked * moneyPerHour;
	}

}

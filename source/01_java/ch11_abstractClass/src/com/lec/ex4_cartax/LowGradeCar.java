package com.lec.ex4_cartax;

public class LowGradeCar extends Car {

	private int tax;
	
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000;
	}
	
	@Override
	public void getSpec() {
		if (getDisplacement() > 1000) {
			tax += (getDisplacement() - 1000) * 100;
		}
		System.out.println("��  �� : " + getColor());
		System.out.println("Ÿ�̾� : " + getTire());
		System.out.println("��ⷮ : " + getDisplacement());
		System.out.println("��  �� : " + getHandle());
		System.out.println("��  �� : " + tax);
		System.out.println("----------------------------");
	}

}

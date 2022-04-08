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
		System.out.println("색  상 : " + getColor());
		System.out.println("타이어 : " + getTire());
		System.out.println("배기량 : " + getDisplacement());
		System.out.println("핸  들 : " + getHandle());
		System.out.println("세  금 : " + tax);
		System.out.println("----------------------------");
	}

}

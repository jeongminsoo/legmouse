package com.lec.ex4_cartax;

import com.lec.constant.CarSpec;

public class TestMain {

	public static void main(String[] args) {
		
		Car car1 = new LowGradeCar(CarSpec.GRAY_CAR, CarSpec.TIRE_NORMAL,
								   CarSpec.DISPLACEMENT_1000, CarSpec.HANDLE_POWER);
		
		car1.getSpec();
		
		Car car2 = new HighGradeCar(CarSpec.RED_CAR, CarSpec.TIRE_WIDE,
								    CarSpec.DISPLACEMENT_2200, CarSpec.HANDLE_POWER);
		
		car2.getSpec();
	}
}

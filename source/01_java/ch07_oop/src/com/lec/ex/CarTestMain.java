package com.lec.ex;

public class CarTestMain {

	public static void main(String[] args) {
		
		Car myCar = new Car();	
		
		myCar.setColor("red");
		
		
		Car yourCar = new Car();
		
		yourCar.setColor("gray");
		
		
		System.out.println(myCar.getColor());
		System.out.println(yourCar.getColor());
		
		
		myCar.drive();
		myCar.park();
		myCar.race();
		
		yourCar.drive();

		System.out.println(myCar.getSpeed());
		System.out.println(yourCar.getSpeed());
	}
}

package com.lec.ex;

public class Car {
	private String color; // 색상
	private int cc;       // 배기량
	private int speed;	  // 속도
	
	public void drive() {
		speed = 60;
		System.out.printf("%s색 차를 운전한다. 지금 속도 : %d\n", color, speed);
	}
	
	public void park() {
		speed = 0;
		System.out.printf("%s색 차를 주차한다. 지금 속도 : %d\n", color, speed);
	}
	
	public void race() {
		speed = 120;
		System.out.printf("%s색 차를 레이싱한다. 지금 속도 : %d\n", color, speed);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getCc() {
		return cc;
	}
	
	public int getSpeed() {
		return speed;
	}
	
//	Car(String color, int cc, int speed) {
//		this.color = color;
//		this.cc = cc;
//		this.speed = speed;
//	}
//	
//	Car(String color, int cc) {
//		this.color = color;
//		this.cc = cc;
//	}
//	
//	Car(String color) {
//		this.color = color;
//	}
}

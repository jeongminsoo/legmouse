package com.lec.ex11_final;

public class Animal {

	private int speed;
	
	public void running() {
		speed += 5;
		System.out.println("¶Ù°í ÀÖ¾î¿ä. ÇöÀç ¼Óµµ : " + speed);
	}
	public final void stop() {
		speed = 0;
		System.out.println("¸ØÃã");
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}

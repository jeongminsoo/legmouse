package com.lec.ex2_human;

public class ManTest {

	public static void main(String[] args) {
		
		Man m1 = new Man(31, 181, 80.0, "010-3702-9161");
		
		m1.calculateBMI();
		
		System.out.printf("m1ÀÇ BMI : %.2f", m1.calculateBMI());
	}
}

package com.lec.homework;

public class Ex {

	public static void main(String[] args) {
		
		int korScore = 88;
		int engScore = 91;
		int mathScore = 99;
		
		int total = korScore + engScore + mathScore;
		double average = total / 3.0;
		
		System.out.println("±¹¾î : " + korScore);
		System.out.println("¿µ¾î : " + engScore);
		System.out.println("¼öÇÐ : " + mathScore);
		
		System.out.println("ÃÑÁ¡ : " + total);
		System.out.println("Æò±Õ : " + average);
	}
}

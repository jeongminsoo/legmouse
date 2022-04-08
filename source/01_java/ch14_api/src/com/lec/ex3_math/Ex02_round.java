package com.lec.ex3_math;

public class Ex02_round {

	public static void main(String[] args) {
		
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("9.15를 올림 : " + (int)Math.ceil(9.15));
		System.out.println("9.15를 반올림 : " + Math.round(9.15));
		System.out.println("9.15를 내림 : " + (int)Math.floor(9.15));
		System.out.println("소수점 첫번째자리에서 반올림, 올림, 버림");
		System.out.println("9.15를 올림 : " + Math.ceil(9.15*10)/10);
		System.out.println("9.15를 반올림 : " + Math.round(9.15*10)/10.0);
		System.out.println("9.15를 내림 : " + Math.floor(9.15*10)/10);
		System.out.println("일의 자리에서 반올림, 올림, 내림");
		System.out.println("85를 올림 : " + (int)Math.ceil(85/10.0)*10);
		System.out.println("85를 반올림 : " + Math.round(85/10.0)*10);
		System.out.println("85를 내림 : " + (int)Math.floor(85/10.0)*10);
	}
}

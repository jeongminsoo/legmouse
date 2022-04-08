package com.lec.ex3_math;

import java.util.Random;

public class Ex03_radom {

	public static void main(String[] args) {
		
		System.out.println("0~45미만의 double 난수 : " + Math.random()*45);
		System.out.println("0~45미만의 double 정수 난수 : " + (int)(Math.random()*45));
		System.out.println("로또 번호 뽑기 : " + ((int)(Math.random()*45)+1));
		Random random = new Random();
		System.out.println("int 난수 : " + random.nextInt());
		System.out.println("double 난수 : " + random.nextDouble());
		System.out.println("T/F 중 하나 난수 : " + random.nextBoolean());
		System.out.println("0~2사이의 정수 난수 : " + random.nextInt(3));
		System.out.println("0~44사이의 정수 난수 : " + random.nextInt(45));
		System.out.println("로또 번호 뽑기 : " + (random.nextInt(45) + 1));
	}
}

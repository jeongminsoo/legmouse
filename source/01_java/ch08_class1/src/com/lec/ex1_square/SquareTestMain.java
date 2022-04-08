package com.lec.ex1_square;

public class SquareTestMain {

	public static void main(String[] args) {
		
		Square s1 = new Square();
		
		Square s2 = new Square(10);
		
		System.out.println("s1의 한변의 길이 : " + s1.getSide());
		s1.setSide(5);
		System.out.println("s1의 한변의 길이 : " + s1.getSide());
		
		System.out.println("s2의 한변의 길이 : " + s2.getSide());
		s2.setSide(50);
		System.out.println("s2의 한변의 길이 : " + s2.getSide());
		
		System.out.println("s1의 넓이 : " + s1.area());
		System.out.println("s2의 넓이 : " + s2.area());
	}
}

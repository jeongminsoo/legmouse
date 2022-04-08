package com.lec.ex1_square;
// 매개변수가 있는 생성자를 생성하면, 꼭! 매개변수가 없는 생성자를 생성할 것.
public class Square {
	private int side;
	
	public Square() {
		System.out.println("매개변수 없는 생성자 함수 호출됨");
	}
	
	public Square(int side) {
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출됨. side 초기화");
	}
	
	public int area() {
		return side*side;
	}
	
	public void setSide(int side) {
		this.side = side;
	}
	
	public int getSide() {
		return side;
	}
}

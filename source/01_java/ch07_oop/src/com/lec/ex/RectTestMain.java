package com.lec.ex;

public class RectTestMain {

	public static void main(String[] args) {
		
		Rect r1 = new Rect();
		
		Rect r2 = new Rect();
		
		r1.setWidth(30);
		r1.setHeight(40);

		r2.setWidth(3);
		r2.setHeight(4);
		
		System.out.println("r1�� ���� : " + r1.getWidth());
		System.out.println("r1�� ���� : " + r1.getHeight());
		System.out.println("r1�� ���� : " + r1.area());
		System.out.println("r2�� ���� : " + r2.getHeight());
		System.out.println("r2�� ���� : " + r2.getWidth());
		System.out.println("r2�� ���� : " + r2.area());
	}
}

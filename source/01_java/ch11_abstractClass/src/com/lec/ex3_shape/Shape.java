package com.lec.ex3_shape;

public abstract class Shape {
	
	public void draw() {
		String className = this.getClass().getName();
		System.out.println(className + "도형을 그려요");
	}
	public abstract double computeArea();
}

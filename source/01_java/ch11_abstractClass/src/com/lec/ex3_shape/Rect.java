package com.lec.ex3_shape;

public class Rect extends Shape {

	private int w;
	private int h;
	
	public Rect() {
	}
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double computeArea() {
		return w * h;
	}

}

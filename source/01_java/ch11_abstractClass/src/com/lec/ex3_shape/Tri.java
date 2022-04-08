package com.lec.ex3_shape;

public class Tri extends Shape{

	private int w;
	private int h;
	
	public Tri(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double computeArea() {
		return w * h * 0.5;
	}

}

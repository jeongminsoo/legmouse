package com.lec.ex3_shape;

import com.lec.constant.*;

public class Cir extends Shape{

	private int r;
	
	public Cir(int r) {
		this.r = r;
	}
	
	@Override
	public double computeArea() {
		return Constant.PI * r * r;
	}

}

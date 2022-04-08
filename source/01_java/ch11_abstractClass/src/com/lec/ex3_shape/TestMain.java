package com.lec.ex3_shape;

public class TestMain {

	public static void main(String[] args) {
		
		Shape[] shape = { new Rect(10, 5),
						  new Tri(5, 6),
						  new Cir(5)};
		
		for (Shape sh : shape) {
			sh.draw();
			System.out.println(sh.computeArea());
		}

	}
}

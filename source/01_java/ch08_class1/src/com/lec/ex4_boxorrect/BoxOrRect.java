package com.lec.ex4_boxorrect;

public class BoxOrRect {

	private int width;
	private int height;
	private int depth;
	private int volume;
	
	public BoxOrRect() {
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width * height;
	}
	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width * height * depth;
	}
	public int getVolume() {
		return volume;
	}
	public void vPrint() {
		if (depth != 0) {
			System.out.println("���Ǵ� " + volume);
		} else {
			System.out.println("���̴� " + volume);
		}
	}
	
}

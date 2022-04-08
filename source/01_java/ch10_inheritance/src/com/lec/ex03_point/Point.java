package com.lec.ex03_point;

public class Point {

	private int x;
	private int y;
	
	public Point() {
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void pointPrint() {
		System.out.println("2���� ��ǥ : x = " + x + ", y = " + y);
	}
	public String infoString() {
		return "2���� ��ǥ : x = " + x + ", y = " + y;
	}
	@Override
	public String toString() {
		return "2���� ��ǥ : x = " + x + ", y = " + y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

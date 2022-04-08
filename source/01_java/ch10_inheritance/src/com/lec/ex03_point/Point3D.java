package com.lec.ex03_point;

public class Point3D extends Point {

	private int z;
	
	public Point3D() {
	}
	public Point3D(int x, int y, int z) {
		setX(x);
		setY(y);
		this.z = z;
	}
	public void point3DPrint() {
		System.out.println("3Â÷¿ø ÁÂÇ¥ : x = " + getX() + ", y = " + getY() + ", z = " + z);
	}
	public String info3DString() {
		return "3Â÷¿ø ÁÂÇ¥ : x = " + getX() + ", y = " + getY() + ", z = " + z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}

package com.lec.ex4_object;

public class Point3D implements Cloneable{

	private double x;
	private double y;
	private double z;
	
	public Point3D() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public String toString() {
		return String.format("[%f, %f, %f]", x, y, z);
	}
	@Override
	public boolean equals(Object obj) {
		Point3D tempObj = (Point3D)obj;
		if (obj != null && obj instanceof Point3D) {
			boolean xChk = x == tempObj.x;
			boolean yChk = y == tempObj.y;
			boolean zChk = z == tempObj.z;
			return xChk && yChk && zChk;
		} else {
			return false;
		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

package com.lec.ex03_point;

public class TestMain {

	public static void main(String[] args) {
		
		Point point = new Point(5, 5);
		
		point.setX(10);
		point.pointPrint();
		System.out.println(point.infoString());
		System.out.println(point);
		
		Point3D point3d = new Point3D(1, 2, 3);
		
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString());
	}

}

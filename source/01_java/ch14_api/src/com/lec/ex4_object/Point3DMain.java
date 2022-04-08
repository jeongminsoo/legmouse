package com.lec.ex4_object;

public class Point3DMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point3D p1 = new Point3D();
		
		Point3D p2 = new Point3D(1.1, 2.2, 3.3);
		
		Point3D p3 = (Point3D)p1.clone();
		
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		System.out.println("p3 : " + p3);
		System.out.println(p1.equals(p2) ? "같다" : "다르다");
		System.out.println(p1.equals(p3) ? "같다" : "다르다");
	}
}

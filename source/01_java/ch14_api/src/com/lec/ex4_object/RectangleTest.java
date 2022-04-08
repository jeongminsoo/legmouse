package com.lec.ex4_object;

public class RectangleTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Rectangle r1 = new Rectangle();
		
		r1.setWidth(10);
		r1.setHeight(10);
//		System.out.println(r1);
		
		Rectangle r2 = (Rectangle)r1.clone();
		
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " + r2);
		System.out.println(r1.equals(r2) ? "같은 사각형" : "다른 사각형");
		System.out.println(r1 == r2 ? "복제한게 아니고 같은 주소를 가리킴" : "다른 주소를 가리킴");
		
		if (r1 != r2 && r1.equals(r2)) {
			System.out.println("복제 성공");
		} else {
			System.out.println("복제 실패");
		}
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		
	}
}

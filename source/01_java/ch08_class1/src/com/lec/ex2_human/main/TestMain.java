package com.lec.ex2_human.main;

import com.lec.ex2_human.*;
// ���ʿ��� package import ���� : ctrl + shift + o
public class TestMain {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		
		if (i == j) {
			System.out.println("����");
		} else {
			System.out.println("�ٸ���");
		}
		
		String name = "ȫ�浿";
		String name2 = "ȫ�浿";
		
		System.out.println(name.equals(name2));
		
		Woman she1 = new Woman();
		Woman she2 = new Woman();
		
		System.out.println(she1.equals(she2));
		
		Man he1 = new Man(31, 181, 80.0);
		Man he2 = new Man(30, 180, 79.0);
		Man he3; // ���۷��� ������ ����
		
		he3 = he2;
		
		Man he4 = new Man(30, 180, 79.0);
		
		if ( he2.equals(he3)) {
			System.out.println("����(�����ּ�)");
		}
		if ( !he2.equals(he4)) {
			System.out.println("�ٸ���(�ٸ��ּ�)");
		}
		
		he1.setHeight(185);
		he1.setWeight(75.5);
		
		if (he1.calculateBMI() > 30) {
			System.out.println("�ǰ��ϼ���");
		} else {
			System.out.println("�ǰ��ϰڳ׿�");
		}
	}

}

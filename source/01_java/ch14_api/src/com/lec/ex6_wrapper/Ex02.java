package com.lec.ex6_wrapper;

public class Ex02 {

	public static void main(String[] args) {
		
		double i = 10.1;
		double j = 10.1;
		double sum = i + j;
		
		System.out.println("���� " + sum);
		System.out.println(i == j ? "�� int�� ����" : "�� int�� �ٸ���");
		
		Double iObj = 10.1;
		Double jObj = new Double(10.1);
		sum = iObj + jObj;//sum = iObj.intValue() + jObj.intValue();
		
		System.out.println("���� " + sum);
		System.out.println(iObj.equals(jObj) ? "�� wrapper��ü ���� ����" : "�� wrapper��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");
			
		
	}
}

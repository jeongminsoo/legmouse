package com.lec.ex6_wrapper;

public class Ex01 {

	public static void main(String[] args) {
		
		int i = 10;
		int j = 10;
		int sum = i + j;
		
		System.out.println("���� " + sum);
		System.out.println(i == j ? "�� int�� ����" : "�� int�� �ٸ���");
		
		Integer iObj = new Integer(10);
		Integer jObj = new Integer(10);
		sum = iObj.intValue() + jObj.intValue();
		
		System.out.println("���� " + sum);
		System.out.println(iObj.equals(jObj) ? "�� wrapper��ü ���� ����" : "�� wrapper��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");
			
		
	}
}

package com.lec.ex09_super;

public class Person {

	private String name;
	private String mind;
	
	public Person() {
		System.out.println("�Ű�����=�Ķ����=���ڰ� ���� Person ������");
	}
	public Person(String name, String mind) {
		this.name = name;
		this.mind = mind;
		System.out.println("�Ű����� 2��¥�� Person ������");
	}
	public void intro() {
		System.out.println(name + "��(��) " + mind);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMind() {
		return mind;
	}
	public void setMind(String mind) {
		this.mind = mind;
	}
	
}

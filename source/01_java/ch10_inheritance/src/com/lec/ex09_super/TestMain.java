package com.lec.ex09_super;

public class TestMain {

	public static void main(String[] args) {
		
		Person papa = new Person();
		papa.setName("�ƺ���");
		papa.setMind("�׶���");
		papa.intro();
		System.out.println("----------------------------");
		Person mama = new Person("������", "������");
		mama.intro();
		System.out.println("----------------------------");
		Baby child1 = new Baby();
		child1.setName("�Ʊ��");
		child1.setMind("�Ϳ���");
		child1.intro();
		System.out.println("----------------------------");
		Baby child2 = new Baby("�Ʊ��", "�ʹ��Ϳ���");
		child2.intro();
		}
}

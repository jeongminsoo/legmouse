package com.lec.ex09_super;

public class TestMain {

	public static void main(String[] args) {
		
		Person papa = new Person();
		papa.setName("¾Æºü°õ");
		papa.setMind("¶×¶×ÇØ");
		papa.intro();
		System.out.println("----------------------------");
		Person mama = new Person("¾ö¸¶°õ", "³¯¾ÂÇØ");
		mama.intro();
		System.out.println("----------------------------");
		Baby child1 = new Baby();
		child1.setName("¾Æ±â°õ");
		child1.setMind("±Í¿©¿ö");
		child1.intro();
		System.out.println("----------------------------");
		Baby child2 = new Baby("¾Æ±â°õ", "³Ê¹«±Í¿©¿ö");
		child2.intro();
		}
}

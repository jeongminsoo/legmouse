package com.lec.ex5_person;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		
		PersonInfo hong = new PersonInfo();
		
		hong.setName("È«°æ¹Î");
		hong.setAge(40);
		hong.setGender('m');
		hong.print();
		
		
		PersonInfo[] people = { new PersonInfo("È«±æµ¿", 20, 'm'),
								new PersonInfo("½Å±æµ¿", 20, 'w')};
		
		for (PersonInfo p : people) {
			p.print();
		}
		
	}
}

package com.lec.ex5_person;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		
		PersonInfo hong = new PersonInfo();
		
		hong.setName("ȫ���");
		hong.setAge(40);
		hong.setGender('m');
		hong.print();
		
		
		PersonInfo[] people = { new PersonInfo("ȫ�浿", 20, 'm'),
								new PersonInfo("�ű浿", 20, 'w')};
		
		for (PersonInfo p : people) {
			p.print();
		}
		
	}
}

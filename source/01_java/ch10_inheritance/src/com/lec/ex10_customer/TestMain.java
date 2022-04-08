package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer("ȫ", "010-9999-9999", "����", "1995-01-01");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		
		Staff staff = new Staff("��", "010-8888-8888", "2022-09-01", "������");
		
		Person person = new Person("��", "010-7777-7777");
		
		Person[] p = {customer, staff, person};
		
//		for(int i = 0; i < p.length; i++) {
//			System.out.println(p[i].infoString());
//		}
		for(Person pp : p) {
			System.out.println(pp.infoString());
		}
		for (Person pp : p) {
			if (pp instanceof Customer) {
				((Customer)pp).buy(1000);
			} else {
				System.out.println("���Ŵ� Customer�� �����մϴ�.");
			}
		}
	}
}

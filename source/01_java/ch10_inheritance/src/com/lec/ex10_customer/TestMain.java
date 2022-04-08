package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer("홍", "010-9999-9999", "서울", "1995-01-01");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		
		Staff staff = new Staff("김", "010-8888-8888", "2022-09-01", "개발팀");
		
		Person person = new Person("이", "010-7777-7777");
		
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
				System.out.println("구매는 Customer만 가능합니다.");
			}
		}
	}
}

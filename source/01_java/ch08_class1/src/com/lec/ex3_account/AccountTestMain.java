package com.lec.ex3_account;

public class AccountTestMain {

	public static void main(String[] args) {
		
		Account hong = new Account("110-1", "홍길동", 21000000);
		Account shin = new Account("110-2", "신길동");
		Account acc = new Account();
		
		acc.setAccountNo("110-3");
		acc.setOwnerName("유길동");
		
		System.out.println(hong.infoPrint());
		System.out.println(shin.infoPrint());
		System.out.println(acc.infoPrint());
		
		shin.deposit(2000);
		shin.withdraw(3000);
		hong.withdraw(20000);
		acc.withdraw(10);
		
		System.out.println(hong.infoPrint());
		System.out.println(shin.infoPrint());
		System.out.println(acc.infoPrint());
	}

}

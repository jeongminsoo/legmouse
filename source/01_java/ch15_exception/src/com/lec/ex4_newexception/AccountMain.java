package com.lec.ex4_newexception;

public class AccountMain {

	public static void main(String[] args) {
		
		Account ac1 = new Account("111-111", "ȫ�浿");
		Account ac2 = new Account("111-222", "�ű浿", 2000);
		
		ac1.deposit(1000);
		ac2.deposit(1000);
		
		try {
			ac1.withdraw(2000);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		try {
			ac2.withdraw(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

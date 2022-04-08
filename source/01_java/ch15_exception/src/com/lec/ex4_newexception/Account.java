package com.lec.ex4_newexception;

public class Account {

	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void deposit(int money) {
		System.out.println("예금 전 : " + this);
		balance += money;
		System.out.println("예금 후 : " + this);
	}
	
	public void withdraw(int money) throws Exception {
		if (balance < money) {
			throw new Exception("잔액이 부족합니다.\n");
		}
		System.out.println("출금 전 : " + this);
		balance -= money;
		System.out.println("출금 후 : " + this);
	}
	
	@Override
	public String toString() {
		return "계좌번호 : " + accountNo + "\t예금주 : " + ownerName + "\t잔액 : " + balance;
	}
}

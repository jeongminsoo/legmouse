package com.lec.ex3_account;

public class Account {

	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)´Ô %d¿ø °èÁÂ °³¼³ °¨»çÇÕ´Ï´Ù.\n", accountNo, ownerName, balance);
	}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)´Ô °èÁÂ °³¼³ °¨»çÇÕ´Ï´Ù.\n", accountNo, ownerName);
	}
	public Account() {
	}
	public void deposit(int money) {
		if (money > 0) {
			balance += money;
		} else {
			System.out.println("Àß¸øµÈ °ªÀÔ´Ï´Ù.");
		}
	}
	public void withdraw(int money) {
		if (money <= balance) {
			balance -= money;
		} else {
			System.out.printf("%s´Ô ÀÜ¾×ÀÌ ºÎÁ·ÇÕ´Ï´Ù.\n", ownerName);
		}
	}
	public String infoPrint() {
		return String.format("%s(%s)´Ô ÀÜ¾× : %d¿ø", ownerName, accountNo, balance);
//		return ownerName + "(" + accountNo + ") ´Ô ÀÜ¾× : " + balance + "¿ø";
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}

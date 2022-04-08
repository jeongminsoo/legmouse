package com.lec.ex14_account;

public class Account {

	private String accountNo;
	private String ownerName;
	private int balance;

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)님 %d원 계좌 개설 감사합니다.\n", ownerName, accountNo, balance);
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)님 계좌 개설 감사합니다.\n", ownerName, accountNo);
	}

	public Account() {
	}

	public void deposit(int money) {
		if (money > 0) {
			balance += money;
			System.out.printf("%s(%s)님 %d원 입금완료했습니다. 현재 잔액 : %d\n", ownerName, accountNo, money, balance);
		} else {
			System.out.println("잘못된 값입니다.");
		}
	}

	public void withdraw(int money) {
		if (money <= balance) {
			balance -= money;
			System.out.printf("%s(%s)님 %d원 출금완료했습니다. 현재 잔액 : %d\n", ownerName, accountNo, money, balance);
		} else {
			System.out.printf("%s님 잔액이 부족합니다.\n", ownerName);
		}
	}

	public String infoPrint() {
		return String.format("%s(%s)님 잔액 : %d원", ownerName, accountNo, balance);
//		return ownerName + "(" + accountNo + ") 님 잔액 : " + balance + "원";
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

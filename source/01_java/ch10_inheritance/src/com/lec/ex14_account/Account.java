package com.lec.ex14_account;

public class Account {

	private String accountNo;
	private String ownerName;
	private int balance;

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)�� %d�� ���� ���� �����մϴ�.\n", ownerName, accountNo, balance);
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)�� ���� ���� �����մϴ�.\n", ownerName, accountNo);
	}

	public Account() {
	}

	public void deposit(int money) {
		if (money > 0) {
			balance += money;
			System.out.printf("%s(%s)�� %d�� �ԱݿϷ��߽��ϴ�. ���� �ܾ� : %d\n", ownerName, accountNo, money, balance);
		} else {
			System.out.println("�߸��� ���Դϴ�.");
		}
	}

	public void withdraw(int money) {
		if (money <= balance) {
			balance -= money;
			System.out.printf("%s(%s)�� %d�� ��ݿϷ��߽��ϴ�. ���� �ܾ� : %d\n", ownerName, accountNo, money, balance);
		} else {
			System.out.printf("%s�� �ܾ��� �����մϴ�.\n", ownerName);
		}
	}

	public String infoPrint() {
		return String.format("%s(%s)�� �ܾ� : %d��", ownerName, accountNo, balance);
//		return ownerName + "(" + accountNo + ") �� �ܾ� : " + balance + "��";
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

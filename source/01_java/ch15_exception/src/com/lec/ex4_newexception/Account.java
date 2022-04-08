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
		System.out.println("���� �� : " + this);
		balance += money;
		System.out.println("���� �� : " + this);
	}
	
	public void withdraw(int money) throws Exception {
		if (balance < money) {
			throw new Exception("�ܾ��� �����մϴ�.\n");
		}
		System.out.println("��� �� : " + this);
		balance -= money;
		System.out.println("��� �� : " + this);
	}
	
	@Override
	public String toString() {
		return "���¹�ȣ : " + accountNo + "\t������ : " + ownerName + "\t�ܾ� : " + balance;
	}
}

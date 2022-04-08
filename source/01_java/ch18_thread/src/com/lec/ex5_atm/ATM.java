package com.lec.ex5_atm;

public class ATM {

	private int balance;

	public ATM(int balance) {
		this.balance = balance;
	}

	public synchronized void deposit(int money, String who) {
		System.out.println(who + "�� �Ա� ����");
		balance += money;
		System.out.println(who + "�� " + money + "�� �Ա��߽��ϴ�. �ܾ� : " + balance);
		System.out.println(who + "�� �Ա� ����");
	}

	public synchronized void withdraw(int money, String who) {
		System.out.println(who + "�� ��� ����");
		balance -= money;
		System.out.println(who + "�� " + money + "�� ����߽��ϴ�. �ܾ� : " + balance);
		System.out.println(who + "�� ��� ����");
	}

	public int getBalance() {
		return balance;
	}
}
